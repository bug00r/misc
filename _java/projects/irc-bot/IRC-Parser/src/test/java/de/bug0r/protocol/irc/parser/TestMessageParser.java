package de.bug0r.protocol.irc.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.bug0r.message.irc.impl.AdminMessage;
import de.bug0r.message.irc.impl.AwayMessage;
import de.bug0r.message.irc.impl.ConnectMessage;
import de.bug0r.message.irc.impl.InviteMessage;
import de.bug0r.message.irc.impl.JoinMessage;
import de.bug0r.message.irc.impl.KickMessage;
import de.bug0r.message.irc.impl.KillMessage;
import de.bug0r.message.irc.impl.LinksMessage;
import de.bug0r.message.irc.impl.ListMessage;
import de.bug0r.message.irc.impl.ModeMessage;
import de.bug0r.message.irc.impl.NamesMessage;
import de.bug0r.message.irc.impl.NickMessage;
import de.bug0r.message.irc.impl.NoticeMessage;
import de.bug0r.message.irc.impl.NumericMessage;
import de.bug0r.message.irc.impl.OperMessage;
import de.bug0r.message.irc.impl.PartMessage;
import de.bug0r.message.irc.impl.PingMessage;
import de.bug0r.message.irc.impl.PrivmsgMessage;
import de.bug0r.message.irc.impl.QuitMessage;
import de.bug0r.message.irc.impl.ServlistMessage;
import de.bug0r.message.irc.impl.SqueryMessage;
import de.bug0r.message.irc.impl.TopicMessage;
import de.bug0r.message.irc.impl.WhoisMessage;
import de.bug0r.message.irc.impl.WhowasMessage;
import de.bug0r.protocol.irc.parser.impl.AdminParser;
import de.bug0r.protocol.irc.parser.impl.AwayParser;
import de.bug0r.protocol.irc.parser.impl.ConnectParser;
import de.bug0r.protocol.irc.parser.impl.InviteParser;
import de.bug0r.protocol.irc.parser.impl.JoinParser;
import de.bug0r.protocol.irc.parser.impl.KickParser;
import de.bug0r.protocol.irc.parser.impl.KillParser;
import de.bug0r.protocol.irc.parser.impl.LinksParser;
import de.bug0r.protocol.irc.parser.impl.ListParser;
import de.bug0r.protocol.irc.parser.impl.ModeParser;
import de.bug0r.protocol.irc.parser.impl.NamesParser;
import de.bug0r.protocol.irc.parser.impl.NickParser;
import de.bug0r.protocol.irc.parser.impl.NoticeParser;
import de.bug0r.protocol.irc.parser.impl.NumericParser;
import de.bug0r.protocol.irc.parser.impl.OperParser;
import de.bug0r.protocol.irc.parser.impl.PartParser;
import de.bug0r.protocol.irc.parser.impl.PingParser;
import de.bug0r.protocol.irc.parser.impl.PrivMsgParser;
import de.bug0r.protocol.irc.parser.impl.QuitParser;
import de.bug0r.protocol.irc.parser.impl.ServlistParser;
import de.bug0r.protocol.irc.parser.impl.SqueryParser;
import de.bug0r.protocol.irc.parser.impl.TopicParser;
import de.bug0r.protocol.irc.parser.impl.WhoisParser;
import de.bug0r.protocol.irc.parser.impl.WhowasParser;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class TestMessageParser {

	@Test()
	public void testPrivmsgParser() {
		IMessageParser parser = new PrivMsgParser();
		PrivmsgMessage message = (PrivmsgMessage) parser.parse(":bug PRIVMSG #fraternized :Hollas wattn text!!");
		Assert.assertEquals(message.toString(),":bug PRIVMSG #fraternized :Hollas wattn text!!\r\n");
		
		message = (PrivmsgMessage) parser.parse("PRIVMSG #fraternized :Hollas wattn text!! :D");
		Assert.assertEquals(message.toString(),"PRIVMSG #fraternized :Hollas wattn text!! :D\r\n");
	}
	
	@Test()
	public void testQuitParser() {
		IMessageParser parser = new QuitParser();
		QuitMessage message = (QuitMessage) parser.parse(":bug QUIT :Hollas wattn text!!");
		Assert.assertEquals(message.toString(),":bug QUIT :Hollas wattn text!!\r\n");
		
		message = (QuitMessage) parser.parse("QUIT :Hollas wattn text!!");
		Assert.assertEquals(message.toString(),"QUIT :Hollas wattn text!!\r\n");
	}
	
	@Test()
	public void testJoinParser() {
		IMessageParser parser = new JoinParser();
		JoinMessage message = (JoinMessage) parser.parse(":bug JOIN #fraternized");
		Assert.assertEquals(message.toString(),":bug JOIN #fraternized\r\n");
		
		message = (JoinMessage) parser.parse("JOIN #fraternized");
		Assert.assertEquals(message.toString(),"JOIN #fraternized\r\n");
	}
	
	@Test()
	public void testNoticeParser() {
		IMessageParser parser = new NoticeParser();
		NoticeMessage message = (NoticeMessage) parser.parse(":bug NOTICE realBug :Hollas wattn text!!");
		Assert.assertEquals(message.toString(),":bug NOTICE realBug :Hollas wattn text!!\r\n");
		
		message = (NoticeMessage) parser.parse("NOTICE realBug :Hollas wattn text!!");
		Assert.assertEquals(message.toString(),"NOTICE realBug :Hollas wattn text!!\r\n");
	}
	
	@Test()
	public void testNickParser() {
		IMessageParser parser = new NickParser();
		NickMessage message = (NickMessage) parser.parse(":bug NICK realBug");
		Assert.assertEquals(message.toString(),":bug NICK realBug\r\n");
		
		message = (NickMessage) parser.parse("NICK realBug");
		Assert.assertEquals(message.toString(),"NICK realBug\r\n");
	}
	
	@Test()
	public void testPartParser() {
		IMessageParser parser = new PartParser();
		PartMessage message = (PartMessage) parser.parse(":bug PART #fraternized");
		Assert.assertEquals(message.toString(),":bug PART #fraternized\r\n");
		
		message = (PartMessage) parser.parse(":bug PART #fraternized :blabla:P");
		Assert.assertEquals(message.toString(),":bug PART #fraternized :blabla:P\r\n");
		
		message = (PartMessage) parser.parse("PART #fraternized :blabla:P");
		Assert.assertEquals(message.toString(),"PART #fraternized :blabla:P\r\n");
		
		message = (PartMessage) parser.parse("PART #fraternized ::");
		Assert.assertEquals(message.toString(),"PART #fraternized ::\r\n");
		
		message = (PartMessage) parser.parse("PART #fraternized :");
		Assert.assertEquals(message.toString(),"PART #fraternized\r\n");
		
		message = (PartMessage) parser.parse("PART #fraternized");
		Assert.assertEquals(message.toString(),"PART #fraternized\r\n");
		
	}
	
	@Test()
	public void testAdminParser() {
		IMessageParser parser = new AdminParser();
		AdminMessage message = (AdminMessage) parser.parse("ADMIN *.edu.fc");
		Assert.assertEquals(message.toString(),"ADMIN *.edu.fc\r\n");
	}
	
	@Test()
	public void testPingParser() {
		IMessageParser parser = new PingParser();
		PingMessage message = (PingMessage) parser.parse("PING irc.edu.fc");
		Assert.assertEquals(message.toString(),"PING irc.edu.fc\r\n");
		message = (PingMessage) parser.parse("PING :irc.edu.fc");
		Assert.assertEquals(message.toString(),"PING irc.edu.fc\r\n");
		message = (PingMessage) parser.parse("PING bug irc.edu.fc");
		Assert.assertEquals(message.toString(),"PING bug irc.edu.fc\r\n");
	}
	
	@Test()
	public void testConnectParser() {
		IMessageParser parser = new ConnectParser();
		ConnectMessage message = (ConnectMessage) parser.parse("CONNECT irc.edu.fc 6667");
		Assert.assertEquals(message.toString(),"CONNECT irc.edu.fc 6667\r\n");
		message = (ConnectMessage) parser.parse("CONNECT irc.edu.fc 6667 irc.remote.server");
		Assert.assertEquals(message.toString(),"CONNECT irc.edu.fc 6667 irc.remote.server\r\n");
	}
	
	@Test()
	public void testInviteParser() {
		IMessageParser parser = new InviteParser();
		InviteMessage message = (InviteMessage) parser.parse("INVITE bug0r #fraternized");
		Assert.assertEquals(message.toString(),"INVITE bug0r #fraternized\r\n");
		message = (InviteMessage) parser.parse(":bug0r2!bla@hierundso.de INVITE bug0r #fraternized");
		Assert.assertEquals(message.toString(),":bug0r2!bla@hierundso.de INVITE bug0r #fraternized\r\n");
	}
	
	@Test()
	public void testKickParser() {
		IMessageParser parser = new KickParser();
		KickMessage message = (KickMessage) parser.parse("KICK #fraternized bug0r");
		Assert.assertEquals(message.toString(),"KICK #fraternized bug0r\r\n");
		
		message = (KickMessage) parser.parse("KICK #fraternized,#channel2 bug0r");
		Assert.assertEquals(message.toString(),"KICK #fraternized,#channel2 bug0r\r\n");
		
		message = (KickMessage) parser.parse("KICK #fraternized bug0r,bug0r2");
		Assert.assertEquals(message.toString(),"KICK #fraternized bug0r,bug0r2\r\n");
		
		message = (KickMessage) parser.parse("KICK #fraternized,#channel2 bug0r,bug0r2");
		Assert.assertEquals(message.toString(),"KICK #fraternized,#channel2 bug0r,bug0r2\r\n");
		
		message = (KickMessage) parser.parse("KICK #fraternized bug0r :kicktext");
		Assert.assertEquals(message.toString(),"KICK #fraternized bug0r :kicktext\r\n");
		
		message = (KickMessage) parser.parse("KICK #fraternized,#channel2 bug0r :kicktext");
		Assert.assertEquals(message.toString(),"KICK #fraternized,#channel2 bug0r :kicktext\r\n");
		
		message = (KickMessage) parser.parse("KICK #fraternized bug0r,bug0r2 :kicktext");
		Assert.assertEquals(message.toString(),"KICK #fraternized bug0r,bug0r2 :kicktext\r\n");
		
		message = (KickMessage) parser.parse("KICK #fraternized,#channel2 bug0r,bug0r2 :kicktext");
		Assert.assertEquals(message.toString(),"KICK #fraternized,#channel2 bug0r,bug0r2 :kicktext\r\n");
		
		message = (KickMessage) parser.parse(":derAdmin KICK #fraternized bug0r");
		Assert.assertEquals(message.toString(),":derAdmin KICK #fraternized bug0r\r\n");
		
		message = (KickMessage) parser.parse(":derAdmin KICK #fraternized bug0r :kicktext");
		Assert.assertEquals(message.toString(),":derAdmin KICK #fraternized bug0r :kicktext\r\n");
	}
	
	@Test()
	public void testKillParser() {
		IMessageParser parser = new KillParser();
		KillMessage message = (KillMessage) parser.parse("KILL bug0r (wattn comment)");
		Assert.assertEquals(message.toString(),"KILL bug0r (wattn comment)\r\n");
	}
	@Test()
	public void testLinksParser() {
		IMessageParser parser = new LinksParser();
		LinksMessage message = (LinksMessage) parser.parse("LINKS");
		Assert.assertEquals(message.toString(),"LINKS\r\n");
		message = (LinksMessage) parser.parse("LINKS *.edu.net");
		Assert.assertEquals(message.toString(),"LINKS *.edu.net\r\n");
		message = (LinksMessage) parser.parse("LINKS *.edu.net *.edu.net2");
		Assert.assertEquals(message.toString(),"LINKS *.edu.net *.edu.net2\r\n");
	}
	
	@Test()
	public void testListParser() {
		IMessageParser parser = new ListParser();
		ListMessage message = (ListMessage) parser.parse("LIST");
		Assert.assertEquals(message.toString(),"LIST\r\n");
		message = (ListMessage) parser.parse("LIST #bla");
		Assert.assertEquals(message.toString(),"LIST #bla\r\n");
		message = (ListMessage) parser.parse("LIST #bla,#vla2");
		Assert.assertEquals(message.toString(),"LIST #bla,#vla2\r\n");
	}
	
	@Test()
	public void testModeParser() {
		IMessageParser parser = new ModeParser();
		ModeMessage message = (ModeMessage) parser.parse("MODE #Finnish +imI *!*@*.fi");
		Assert.assertEquals(message.toString(),"MODE #Finnish +imI *!*@*.fi\r\n");
		message = (ModeMessage) parser.parse("MODE #Finnish +o Kilroy");
		Assert.assertEquals(message.toString(),"MODE #Finnish +o Kilroy\r\n");
		message = (ModeMessage) parser.parse("MODE #Finnish +imI *!*@*.fi *!*@*.fi");
		Assert.assertEquals(message.toString(),"MODE #Finnish +imI *!*@*.fi *!*@*.fi\r\n");
		message = (ModeMessage) parser.parse("MODE #Fins -s");
		Assert.assertEquals(message.toString(),"MODE #Fins -s\r\n");
		message = (ModeMessage) parser.parse("MODE #eu-opers +l 10");
		Assert.assertEquals(message.toString(),"MODE #eu-opers +l 10\r\n");
		message = (ModeMessage) parser.parse(":bug0r!bla@bls.de.online MODE #Finnish +imI *!*@*.fi");
		Assert.assertEquals(message.toString(),":bug0r!bla@bls.de.online MODE #Finnish +imI *!*@*.fi\r\n");
		message = (ModeMessage) parser.parse(":bug0r!bla@bls.de.online MODE #Finnish +o Kilroy");
		Assert.assertEquals(message.toString(),":bug0r!bla@bls.de.online MODE #Finnish +o Kilroy\r\n");
		message = (ModeMessage) parser.parse(":bug0r!bla@bls.de.online MODE #Finnish +imI *!*@*.fi *!*@*.fi");
		Assert.assertEquals(message.toString(),":bug0r!bla@bls.de.online MODE #Finnish +imI *!*@*.fi *!*@*.fi\r\n");
		message = (ModeMessage) parser.parse(":bug0r!bla@bls.de.online MODE #Fins -s");
		Assert.assertEquals(message.toString(),":bug0r!bla@bls.de.online MODE #Fins -s\r\n");
		message = (ModeMessage) parser.parse(":bug0r!bla@bls.de.online MODE #eu-opers +l 10");
		Assert.assertEquals(message.toString(),":bug0r!bla@bls.de.online MODE #eu-opers +l 10\r\n");
		
		message = (ModeMessage) parser.parse("MODE");
		Assert.assertEquals(message.toString(),"MODE\r\n");
		message = (ModeMessage) parser.parse("MODE Bug0rBot +a");
		Assert.assertEquals(message.toString(),"MODE Bug0rBot +a\r\n");
		
	}
	
	@Test()
	public void testNamesParser() {
		IMessageParser parser = new NamesParser();
		NamesMessage message = (NamesMessage) parser.parse("NAMES");
		Assert.assertEquals(message.toString(),"NAMES\r\n");
		message = (NamesMessage) parser.parse("NAMES #bla");
		Assert.assertEquals(message.toString(),"NAMES #bla\r\n");
		message = (NamesMessage) parser.parse("NAMES #bla,#vla2");
		Assert.assertEquals(message.toString(),"NAMES #bla,#vla2\r\n");
	}
	
	@Test()
	public void testOperParser() {
		IMessageParser parser = new OperParser();
		OperMessage message = (OperMessage) parser.parse("OPER bug0r geheim");
		Assert.assertEquals(message.toString(),"OPER bug0r geheim\r\n");
	}
	
	@Test()
	public void testservlistParser() {
		IMessageParser parser = new ServlistParser();
		ServlistMessage message = (ServlistMessage) parser.parse("SERVLIST");
		Assert.assertEquals(message.toString(),"SERVLIST\r\n");
		message = (ServlistMessage) parser.parse("SERVLIST bug0r");
		Assert.assertEquals(message.toString(),"SERVLIST bug0r\r\n");
		message = (ServlistMessage) parser.parse("SERVLIST bug0r geheim");
		Assert.assertEquals(message.toString(),"SERVLIST bug0r geheim\r\n");
	}
	
	@Test()
	public void testSqueryParser() {
		IMessageParser parser = new SqueryParser();
		SqueryMessage message = (SqueryMessage) parser.parse("SQUERY irchelp :HELP privmsg");
		Assert.assertEquals(message.toString(),"SQUERY irchelp :HELP privmsg\r\n");
		message = (SqueryMessage) parser.parse("SQUERY dict@irc.fr :fr2en blaireau");
		Assert.assertEquals(message.toString(),"SQUERY dict@irc.fr :fr2en blaireau\r\n");
	}
	
	@Test()
	public void testTopicParser() {
		IMessageParser parser = new TopicParser();
		TopicMessage message = (TopicMessage) parser.parse("TOPIC #bla :HELP privmsg");
		Assert.assertEquals(message.toString(),"TOPIC #bla :HELP privmsg\r\n");
		message = (TopicMessage) parser.parse("TOPIC #bla :");
		Assert.assertEquals(message.toString(),"TOPIC #bla :\r\n");
		message = (TopicMessage) parser.parse("TOPIC #bla");
		Assert.assertEquals(message.toString(),"TOPIC #bla\r\n");
		message = (TopicMessage) parser.parse(":bug0r!bla@bls.de.online TOPIC #bla :HELP privmsg");
		Assert.assertEquals(message.toString(),":bug0r!bla@bls.de.online TOPIC #bla :HELP privmsg\r\n");
		message = (TopicMessage) parser.parse(":bug0r!bla@bls.de.online TOPIC #bla :");
		Assert.assertEquals(message.toString(),":bug0r!bla@bls.de.online TOPIC #bla :\r\n");
	}
	
	@Test()
	public void testWhoisParser() {
		IMessageParser parser = new WhoisParser();
		WhoisMessage message = (WhoisMessage) parser.parse("WHOIS #bla bug0r");
		Assert.assertEquals(message.toString(),"WHOIS #bla bug0r\r\n");
		message = (WhoisMessage) parser.parse("WHOIS #bla bug0r,bug0r2");
		Assert.assertEquals(message.toString(),"WHOIS #bla bug0r,bug0r2\r\n");
		message = (WhoisMessage) parser.parse("WHOIS bug0r");
		Assert.assertEquals(message.toString(),"WHOIS bug0r\r\n");
		message = (WhoisMessage) parser.parse("WHOIS bug0r,bug0r2");
		Assert.assertEquals(message.toString(),"WHOIS bug0r,bug0r2\r\n");
	}
	
	@Test()
	public void testWhowasParser() {
		IMessageParser parser = new WhowasParser();
		WhowasMessage message = (WhowasMessage) parser.parse("WHOWAS Wiz");
		Assert.assertEquals(message.toString(),"WHOWAS Wiz\r\n");
		message = (WhowasMessage) parser.parse("WHOWAS Wiz,bug0r");
		Assert.assertEquals(message.toString(),"WHOWAS Wiz,bug0r\r\n");
		message = (WhowasMessage) parser.parse("WHOWAS Mermaid 9");
		Assert.assertEquals(message.toString(),"WHOWAS Mermaid 9\r\n");
		message = (WhowasMessage) parser.parse("WHOWAS Trillian 1 *.edu");
		Assert.assertEquals(message.toString(),"WHOWAS Trillian 1 *.edu\r\n");
	}
	
	@Test()
	public void testAwayParser() {
		IMessageParser parser = new AwayParser();
		AwayMessage message = (AwayMessage) parser.parse("AWAY");
		Assert.assertEquals(message.toString(),"AWAY\r\n");
		message = (AwayMessage) parser.parse("AWAY :got lunch :D");
		Assert.assertEquals(message.toString(),"AWAY :got lunch :D");
		message = (AwayMessage) parser.parse("AWAY :");
		Assert.assertEquals(message.toString(),"AWAY :\r\n");

	}
	
	@Test()
	public void testNumericParser() {
		IMessageParser parser = new NumericParser();
		NumericMessage message = (NumericMessage) parser.parse(":irc.server.de 100 bug0r :Motd oder so");
		Assert.assertEquals(message.toString(),":irc.server.de 100 bug0r :Motd oder so\r\n");
		message = (NumericMessage) parser.parse(":irc.server.de 100 bug0r :");
		Assert.assertEquals(message.toString(),":irc.server.de 100 bug0r\r\n");
		message = (NumericMessage) parser.parse(":irc.server.de 101 bug0r :blabla");
		Assert.assertEquals(message.toString(),":irc.server.de 101 bug0r :blabla\r\n");
		message = (NumericMessage) parser.parse(":irc.server.de 102 bug0r :");
		Assert.assertEquals(message.toString(),":irc.server.de 102 bug0r\r\n");
		message = (NumericMessage) parser.parse(":port80b.se.quakenet.org 311 bug0r fnatic\\rvnSLOT fnatic rootbitch.myraven.de * :shroudBNC User");
		Assert.assertEquals(message.toString(),":port80b.se.quakenet.org 311 bug0r fnatic\\rvnSLOT fnatic rootbitch.myraven.de * :shroudBNC User\r\n");
		
	}
	
}
