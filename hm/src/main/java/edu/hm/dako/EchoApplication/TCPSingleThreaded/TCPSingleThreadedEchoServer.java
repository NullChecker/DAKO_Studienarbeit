package edu.hm.dako.EchoApplication.TCPSingleThreaded;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import edu.hm.dako.EchoApplication.Basics.EchoPDU;

/**
 * Klasse TCPSingleThreadedEchoServer
 * 
 * Nur ein Thread bedient alle Clients
 * 
 * @author Mandl
 * 
 */
public class TCPSingleThreadedEchoServer {
	private static Log log = LogFactory
			.getLog(TCPSingleThreadedEchoServer.class);

	private static int serverPort = 50000;

	// Verbindungstabelle: Hier werden alle aktiven Verbindungen zu Clients
	// verwaltet
	private static Map<String, Socket> connections = new ConcurrentHashMap<String, Socket>();

	// TCP-Socket des Servers (Listen-Socket)
	private static ServerSocket serverSocket;

	// Laenge der Queue des Server-Sockets fuer ankommende
	// Verbindungsaufbauwuensche
	private static final int backlog = 20;

	// Verbindungszaehler
	private static long nrConnections = 0;

	// Streams fuer TCP-Verbindung
	private static ObjectOutputStream out;
	private static ObjectInputStream in;

	/**
	 * Konstruktor
	 */
	public TCPSingleThreadedEchoServer() {
	}

	/**
	 * MainMethode
	 * 
	 * @param args
	 */

	public static void main(String args[]) {
		PropertyConfigurator.configureAndWatch("log4j.server.properties",
				60 * 1000);

		// TCP-Serversocket registrieren
		try {

			serverSocket = new ServerSocket(serverPort, backlog);
			System.out
					.println("TCPSingleThreadedEchoServer wartet auf Clients...");
		} catch (IOException e) {
			log.debug("Exception bei der Socket-Erzeugung: " + e);
			System.exit(9);
		}

		while (true) {
			try {
				// Auf ankommende Verbindungsaufbauwuensche warten
				// TODO
				Socket incomingConnectionFromClient = serverSocket.accept();
				
				// Echo-Request entgegennehmen
				// TODO
				out = new ObjectOutputStream(incomingConnectionFromClient.getOutputStream());
				in = new ObjectInputStream(incomingConnectionFromClient.getInputStream());
				
				// Neue Verbindungen in Verbindungstabelle eintragen
				Object e = in.readObject();
				EchoPDU echo = (EchoPDU) e;				
				
				// Echo-Response senden
				out.writeObject(echo);				

				// TODO
				// Verbindung abbauen
				in.close();
				out.close();
				serverSocket.close();				
			break;
			
			} catch (Exception e) {
				log.error("Socket Exception: " + e);
			}
		}
	}
}