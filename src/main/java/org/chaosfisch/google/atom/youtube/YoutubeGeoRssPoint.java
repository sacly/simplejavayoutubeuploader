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

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("gml:Point")
public class YoutubeGeoRssPoint {
	public @XStreamAlias("gml:pos") String	pos;
}