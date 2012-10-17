package edu.hm.dako.EchoApplication.ReliableUdpMultiThreaded;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.EchoApplication.Basics.AbstractClientThread;
import edu.hm.dako.EchoApplication.Basics.EchoPDU;
import edu.hm.dako.EchoApplication.Basics.SharedClientStatistics;
import edu.hm.dako.EchoApplication.ReliableUdpSocket.ReliableUdpSocket;

/**
 * Klasse ReliableUdpMultiThreadedEchoClientThread
 * 
 * @author Mandl
 * 
 */
// TODO Ganze Klasse implementieren
public class ReliableUdpMultiThreadedEchoClientThread extends
		AbstractClientThread {

	/**
	 * initialize
	 * 
	 * @param serverPort
	 *            : Port des Servers
	 * @param remoteServerAddress
	 *            : Adresse des Servers
	 * @param numberOfClient
	 *            : Laufende Nummer des Test-Clients
	 * @param messagelength
	 *            : Laenge einer Nachricht
	 * @param numberOfMessages
	 *            : Anzahl zu sendender Nachrichten je Thread
	 * @param clientThinkTime
	 *            : Denkzeit des Test-Clients
	 * @param sharedData
	 *            : Gemeinsame Daten der Threads
	 */
	@Override
	public void initialize(int serverPort, String remoteServerAddress,
			int numberOfClient, int messageLength, int numberOfMessages,
			int clientThinkTime, SharedClientStatistics sharedData) {
		// TODO
	}

	/**
	 * Run-Methode fuer den Test-Thread: Client-Thread sendet hier alle Requests
	 * und wartet auf Antworten
	 */
	public void run() {
		// TODO
	}

}