package edu.hm.dako.EchoApplication.UDPSingleThreaded;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.EchoApplication.Basics.AbstractClientThread;
import edu.hm.dako.EchoApplication.Basics.EchoPDU;
import edu.hm.dako.EchoApplication.Basics.SharedClientStatistics;

/**
 * Klasse UDPSingleThreadedEchoClientThread
 *  
 * @author Mandl
 *
 */

//TODO: Ganze Klasse programmieren

public class UDPSingleThreadedEchoClientThread extends AbstractClientThread
{	 
	    /**
	     * initialize
	     * 
	     * @param serverPort: Port des Servers
	     * @param remoteServerAddress: Adresse des Servers
	     * @param numberOfClient: Laufende Nummer des Test-Clients
	     * @param messagelength: Laenge einer Nachricht
	     * @param numberOfMessages: Anzahl zu sendender Nachrichten je Thread
	     * @param clientThinkTime: Denkzeit des Test-Clients
	     * @param sharedData: Gemeinsame Daten der Threads 
	     */
		@Override
		public void initialize(
			int serverPort,
			String remoteServerAddress,
			int numberOfClient, 
			int messageLength, 
			int numberOfMessages,
			int clientThinkTime,
			SharedClientStatistics sharedData)
		{		

			//TODO: Initialisierung
		}

 }