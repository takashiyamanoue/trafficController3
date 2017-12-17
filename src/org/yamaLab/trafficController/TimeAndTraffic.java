package org.yamaLab.trafficController;

import java.util.StringTokenizer;

import org.yamaLab.pukiwikiCommunicator.language.Util;

public class TimeAndTraffic {
	public long time;
	public String traffic;
	public long getTime() {
		return time;
	}
	/*
	 * traffic
	wmessage="#"+packetNumber+" if="+itf+" date="+date+" "+
	         p.sourceMacString+" -> "+p.destinationMacString+
	         " prtcl="+p.protocol+" "+p.sourceIpString+" -> "+p.destinationIpString+
	         " "+p.sport+"->"+p.dport+" "+states[0];
	*/
	public String getDestinationIP() {
		StringTokenizer st=new StringTokenizer(traffic,",");
		String[] rest=new String[1];
		while(st.hasMoreTokens()) {
			String tkn=st.nextToken();
			tkn=Util.skipSpace(tkn);
			if(Util.parseKeyWord(tkn, "dip=", rest)) {
				return rest[0];
			}
		}
		return "*";
	}
	public String getDestinationMac() {
		StringTokenizer st=new StringTokenizer(traffic,",");
		String[] rest=new String[1];
		while(st.hasMoreTokens()) {
			String tkn=st.nextToken();
			tkn=Util.skipSpace(tkn);
			if(Util.parseKeyWord(tkn, "dmac=", rest)) {
				return rest[0];
			}
		}
		return "*";
	}	
	
	public String getSourceIP() {
		StringTokenizer st=new StringTokenizer(traffic,",");
		String[] rest=new String[1];
		while(st.hasMoreTokens()) {
			String tkn=st.nextToken();
			tkn=Util.skipSpace(tkn);
			if(Util.parseKeyWord(tkn, "sip=", rest)) {
				return rest[0];
			}
		}
		return "*";
	}	
}
