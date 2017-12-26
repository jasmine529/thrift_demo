package service.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import service.demo.Hello.Processor;

public class Server {

    public void startServer() {
        try {
            TServerSocket serverTransport = new TServerSocket(1234);
            Hello.Processor process = new Processor(new HelloImpl());
            Factory portFactory = new TBinaryProtocol.Factory(true, true);
            Args args = new Args(serverTransport);
            args.processor(process);
            args.protocolFactory(portFactory);
            TServer server = new TThreadPoolServer(args);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }
}