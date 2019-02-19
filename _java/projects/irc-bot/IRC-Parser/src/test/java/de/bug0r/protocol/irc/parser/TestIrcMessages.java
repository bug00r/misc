package de.bug0r.protocol.irc.parser;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.JoinMessage;
import de.bug0r.message.irc.impl.PrivmsgMessage;
import de.bug0r.message.irc.impl.QuitMessage;

public class TestIrcMessages {

	@Test()
	public void testJoinMessage() {
		
		IIrcMessage joinMessage = new JoinMessage("bug", "#fraternized");
		System.out.println("message: " + joinMessage);		
		Assert.assertEquals(joinMessage.toString(),":bug JOIN #fraternized\r\n");
		
		List<String> channel = new ArrayList<String>();
		channel.add("#channel1");
		channel.add("#channel2");
		channel.add("#channel3");
		
		List<String> passwords = new ArrayList<String>();
		passwords.add("password1");
		passwords.add("password2");
		
		IIrcMessage joinMessage1 = new JoinMessage(channel, passwords);
		System.out.println("message: " + joinMessage1);		
		Assert.assertEquals(joinMessage1.toString(),"JOIN #channel1,#channel2,#channel3 password1,password2\r\n");
		
	}
	
	@Test()
	public void testPrivmsgMessage() {
		
		IIrcMessage privmsgMessage = new PrivmsgMessage("bug", "#fraternized","Hollas wattn text!!");
		System.out.println("message: " + privmsgMessage);		
		Assert.assertEquals(privmsgMessage.toString(),":bug PRIVMSG #fraternized :Hollas wattn text!!\r\n");
		
		privmsgMessage = new PrivmsgMessage(null,"#fraternized","Hollas wattn text!!");
		System.out.println("message: " + privmsgMessage);		
		Assert.assertEquals(privmsgMessage.toString(),"PRIVMSG #fraternized :Hollas wattn text!!\r\n");
		
		privmsgMessage = new PrivmsgMessage("","#fraternized","Hollas wattn text!!");
		System.out.println("message: " + privmsgMessage);		
		Assert.assertEquals(privmsgMessage.toString(),"PRIVMSG #fraternized :Hollas wattn text!!\r\n");
	}
	
	@Test()
	public void testQuitMessage() {
		IIrcMessage quitMessage = new QuitMessage("bug", "ho wattn quit");
		System.out.println("message: " + quitMessage);
		Assert.assertEquals(quitMessage.toString(),":bug QUIT :ho wattn quit\r\n");
		
		quitMessage = new QuitMessage("", "ho wattn quit");
		System.out.println("message: " + quitMessage);
		Assert.assertEquals(quitMessage.toString(),"QUIT :ho wattn quit\r\n");
		
		quitMessage = new QuitMessage(null, "ho wattn quit");
		System.out.println("message: " + quitMessage);
		Assert.assertEquals(quitMessage.toString(),"QUIT :ho wattn quit\r\n");
		
		quitMessage = new QuitMessage(null, null);
		System.out.println("message: " + quitMessage);
		Assert.assertEquals(quitMessage.toString(),"QUIT\r\n");
	
		quitMessage = new QuitMessage(null, "");
		System.out.println("message: " + quitMessage);
		Assert.assertEquals(quitMessage.toString(),"QUIT\r\n");
	}
	
}
