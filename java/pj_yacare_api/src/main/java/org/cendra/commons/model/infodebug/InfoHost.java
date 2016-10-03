package org.cendra.commons.model.infodebug;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.cendra.commons.model.infodebug.javainfo.InfoJava;

public class InfoHost {

	private String hostName = "unknown";
	private String hostAddress = "unknown";
	private InfoOs os = new InfoOs();

	private InfoJava infoJava = new InfoJava();

	public InfoHost() {
		super();
		InetAddress localHost;
		try {
			localHost = InetAddress.getLocalHost();
			hostName = localHost.getHostName();
			hostAddress = localHost.getHostAddress();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	public InfoJava getInfoJava() {
		return infoJava;
	}

	public void setInfoJava(InfoJava infoJava) {
		this.infoJava = infoJava;
	}

	public InfoOs getOs() {
		return os;
	}

	public void setOs(InfoOs os) {
		this.os = os;
	}

}
