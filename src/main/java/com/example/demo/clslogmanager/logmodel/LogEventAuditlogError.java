package com.example.demo.clslogmanager.logmodel;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogEventAuditlogError {
	@JsonProperty("LogTime")
	String logTime;
	@JsonProperty("LogName")
	String logName;
	@JsonProperty("LogHostName")
	String logHostName;
	@JsonProperty("LogIpAdress")
	String logIpAdress;
	@JsonProperty("LogEnvironment")
	String logEnvironment;
	@JsonProperty("LogFunction")
	String logFunction;
	@JsonProperty("LogType")
	String logType;
	@JsonProperty("LogMessage")
	String logMessage;
    @JsonProperty("LogCommunicationResult")
    private String logCommunicationResult;

	public void setLogEventError(String logMessage, int statusCode) throws UnknownHostException {
		setCommonFields();

		this.logType = "auditlog";
		this.logCommunicationResult = Integer.toString(statusCode);
		this.logMessage = logMessage;
	}

	void setCommonFields() throws UnknownHostException {
		final ZoneId zone = ZoneId.of("Europe/Copenhagen");
		LocalDateTime localDateTime = LocalDateTime.now(zone);
		ZoneOffset zoneOffSet = zone.getRules().getOffset(localDateTime);
		OffsetDateTime offsetDateTime = localDateTime.atOffset(zoneOffSet);
		this.logTime = offsetDateTime.toString();

		try {
			InetAddress iNetAddress = InetAddress.getLocalHost();
			this.logHostName = iNetAddress.getHostName();
			this.logIpAdress = iNetAddress.toString();
		} catch (UnknownHostException e) {
			throw e;
		}
		if (logIpAdress.indexOf("/") > -1)
			logIpAdress = logIpAdress.substring(logIpAdress.indexOf("/") + 1);
	}

	public String getLogName() {
		return logName;
	}

	public String getLogIpAdress() {
		return logIpAdress;
	}

	public String getLogEnvironment() {
		return logEnvironment;
	}

	public String getLogFunction() {
		return logFunction;
	}

	public String getLogType() {
		return logType;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public String getLogCommunicationResult() {
		return logCommunicationResult;
	}
}
