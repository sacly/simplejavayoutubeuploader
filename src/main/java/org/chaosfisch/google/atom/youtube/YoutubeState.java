/*******************************************************************************
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: Dennis Fischer
 ******************************************************************************/
package org.chaosfisch.google.atom.youtube;

import java.net.URL;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("yt:state")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "state" })
public class YoutubeState {
	public @XStreamAsAttribute URL		helpUrl;
	public @XStreamAsAttribute String	name;
	public @XStreamAsAttribute String	reasonCode;
	public String						state;
}