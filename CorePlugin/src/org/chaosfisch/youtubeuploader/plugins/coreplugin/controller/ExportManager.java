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

package org.chaosfisch.youtubeuploader.plugins.coreplugin.controller;

import com.google.inject.Inject;
import com.thoughtworks.xstream.XStream;
import org.chaosfisch.youtubeuploader.plugins.coreplugin.models.Account;
import org.chaosfisch.youtubeuploader.plugins.coreplugin.models.Preset;
import org.chaosfisch.youtubeuploader.plugins.coreplugin.models.Queue;
import org.chaosfisch.youtubeuploader.plugins.coreplugin.services.spi.AccountService;
import org.chaosfisch.youtubeuploader.plugins.coreplugin.services.spi.PresetService;
import org.chaosfisch.youtubeuploader.plugins.coreplugin.services.spi.QueueService;

import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dennis
 * Date: 24.01.12
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
class ExportManager
{
	private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"; //NON-NLS
	private final XStream        xStream;
	private final AccountService accountService;
	private final PresetService  presetService;
	private final QueueService   queueService;
	private final JFileChooser   fileChooser;

	@Inject
	public ExportManager(final XStream xStream, final AccountService accountService, final PresetService presetService, final QueueService queueService, final JFileChooser fileChooser)
	{
		this.xStream = xStream;
		this.accountService = accountService;
		this.presetService = presetService;
		this.queueService = queueService;
		this.fileChooser = fileChooser;
		xStream.alias("entries", List.class); //NON-NLS
	}

	public void exportAccount()
	{
		final File file = showSaveDialog("account"); //NON-NLS
		if (file == null) {
			return;
		}

		final List<Account> accounts = accountService.getAll();
		writeObjectToXMLFile(file, accounts, "UTF-8"); //NON-NLS
	}

	public void exportPreset()
	{
		final File file = showSaveDialog("preset"); //NON-NLS
		if (file == null) {
			return;
		}

		final List<Preset> presetEntries = presetService.getAll();
		writeObjectToXMLFile(file, presetEntries, "UTF-8"); //NON-NLS
	}

	public void exportQueue()
	{
		final File file = showSaveDialog("queue"); //NON-NLS
		if (file == null) {
			return;
		}

		final List<Queue> queueEntries = queueService.getQueued();
		writeObjectToXMLFile(file, queueEntries, "UTF-8"); //NON-NLS
	}

	private void writeObjectToXMLFile(final File file, final Object object, final String charset)
	{
		try {
			final FileOutputStream fileOutputStream = new FileOutputStream(file);
			final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, Charset.forName(charset));

			try {
				outputStreamWriter.write(ExportManager.XML_HEADER);
				xStream.toXML(object, outputStreamWriter);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					outputStreamWriter.close();
					bufferedOutputStream.close();
					fileOutputStream.close();
				} catch (IOException ignored) {
					throw new RuntimeException("This shouldn't happen");
				}
			}
		} catch (FileNotFoundException ignored) {
		} catch (IOException ignored) {
			throw new RuntimeException("This shouldn't happen");
		}
	}

	File showSaveDialog(final String name)
	{
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setDragEnabled(true);
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setSelectedFile(new File("export-" + name + "-" + System.currentTimeMillis() + ".xml")); //NON-NLS NON-NLS
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		final int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}
}
