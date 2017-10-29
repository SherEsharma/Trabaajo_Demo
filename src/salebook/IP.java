package salebook;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP {
	public static void main(String[] args) throws UnknownHostException {
		String s=InetAddress.getLocalHost().getHostAddress();
		System.out.println(s);
	}
}
