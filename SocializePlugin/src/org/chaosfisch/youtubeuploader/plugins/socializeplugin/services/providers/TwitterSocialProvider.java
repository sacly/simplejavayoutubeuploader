/*
 * Copyright (c) 2012, Dennis Fischer
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.chaosfisch.youtubeuploader.plugins.socializeplugin.services.providers;

import org.apache.log4j.Logger;
import org.chaosfisch.youtubeuploader.plugins.socializeplugin.APIData;
import org.chaosfisch.youtubeuploader.util.logger.InjectLogger;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: Dennis
 * Date: 14.04.12
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public class TwitterSocialProvider implements ISocialProvider
{
	private Token accessToken;
	private final OAuthService oAuthService = new ServiceBuilder().provider(TwitterApi.class)  //NON-NLS
			.apiKey(APIData.TWITTER_APIKEY).apiSecret(APIData.TWITTER_APISECRET).build();
	@InjectLogger private Logger logger;
	private static final String TWITTER_ACCESS_TOKEN = "onTwitterAccessToken"; //NON-NLS

	@Override public Token getAccessToken()
	{
		return this.accessToken;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override public void setAccessToken(final Token accessToken)
	{
		this.accessToken = accessToken;
	}

	@Override public void authenticate()
	{
		if (this.accessToken != null) {
			return;
		}

		final Token requestToken = this.oAuthService.getRequestToken();
		try {
			Desktop.getDesktop().browse(new URI(this.oAuthService.getAuthorizationUrl(requestToken)));
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		} catch (URISyntaxException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		final String verifier = JOptionPane.showInputDialog(null, "Bestätigungs Code:", "Twitter Account OAuth", JOptionPane.INFORMATION_MESSAGE);

		if (verifier != null) {
			this.accessToken = this.oAuthService.getAccessToken(requestToken, new Verifier(verifier));
		}
	}

	@Override public void publish(final String message)
	{
		if (this.accessToken == null) {
			return;
		}
		final OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, "http://api.twitter.com/1/statuses/update.json"); //NON-NLS
		oAuthRequest.addBodyParameter("status", message); //NON-NLS

		this.oAuthService.signRequest(this.accessToken, oAuthRequest);
		final Response response = oAuthRequest.send();
		if (response.getCode() != 200) {
			this.logger.fatal("Wrong response code: " + response.getCode()); //NON-NLS
			this.logger.fatal(response.getBody());
		}
	}

	@Override public boolean hasValidAccessToken()
	{
		if (this.accessToken == null) {
			return false;
		}
		final OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, "http://api.twitter.com/1/help/test.json"); //NON-NLS
		this.oAuthService.signRequest(this.accessToken, oAuthRequest);
		try {
			final Response response = oAuthRequest.send();
			if (response.getCode() == 200) {
				return true;
			}
		} catch (RuntimeException ex) {
			return false;
		}
		return false;
	}
}