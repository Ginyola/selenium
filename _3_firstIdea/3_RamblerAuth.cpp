// 3_RamblerAuth.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include "pch.h"
#include <iostream>
#include <Poco/Net/POP3ClientSession.h>
#include <Poco/Net/SecureSMTPClientSession.h>
#include <Poco/Net/Context.h>
#include <Poco/Net/SecureStreamSocket.h>
#include <Poco/Net/NetException.h>
#include <Poco/Net/SocketAddress.h>



int main()
{
	std::string login = "";
	std::string password = "";

	Poco::Net::SocketAddress addr("pop.rambler.ru", 995);
	Poco::Net::SecureStreamSocket sss(addr);
	std::cout << "Start session...\n" << std::endl;
	Poco::Net::POP3ClientSession session(sss);
	std::cout << "Done\n" << std::endl;

	try
	{
		session.login(login, password);
		std::cout << session.messageCount() << std::endl;
	}
	catch (Poco::Net::POP3Exception &e)
	{
		std::cout << e.what() << std::endl;
	}
	
	system("pause");
}
