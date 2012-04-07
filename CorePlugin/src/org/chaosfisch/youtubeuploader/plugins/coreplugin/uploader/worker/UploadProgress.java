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

package org.chaosfisch.youtubeuploader.plugins.coreplugin.uploader.worker;

import org.chaosfisch.youtubeuploader.plugins.coreplugin.models.entities.QueueEntry;

/**
 * Created by IntelliJ IDEA.
 * User: Dennis
 * Date: 07.01.12
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
public class UploadProgress
{
	private final QueueEntry queueEntry;
	private final double     fileSize;
	private       long       time;
	private       double     totalBytesUploaded;
	private       double     diffBytes;
	private       long       diffTime;

	public UploadProgress(final QueueEntry queueEntry, final double fileSize, final double totalBytesUploaded, final double diffBytes, final long time, final long diffTime)
	{
		this.queueEntry = queueEntry;
		this.fileSize = fileSize;
		this.totalBytesUploaded = totalBytesUploaded;
		this.diffBytes = diffBytes;
		this.time = time;
		this.diffTime = diffTime;
	}

	public QueueEntry getQueueEntry()
	{
		return this.queueEntry;
	}

	public double getFileSize()
	{
		return this.fileSize;
	}

	public double getTotalBytesUploaded()
	{
		return this.totalBytesUploaded;
	}

	public long getTime()
	{
		return this.time;
	}

	public void setTotalBytesUploaded(final double totalBytesUploaded)
	{
		this.totalBytesUploaded = totalBytesUploaded;
	}

	public double getDiffBytes()
	{
		return this.diffBytes;
	}

	public void setDiffBytes(final double diffBytes)
	{
		this.diffBytes = diffBytes;
	}

	public void setTime(final long time)
	{
		this.time = time;
	}

	public long getDiffTime()
	{
		return this.diffTime;
	}

	public void setDiffTime(final long diffTime)
	{
		this.diffTime = diffTime;
	}
}