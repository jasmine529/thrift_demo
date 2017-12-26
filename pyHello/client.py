import sys
import Hello
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

try:
    transport = TSocket.TSocket('localhost',1234)
    transport = TTransport.TBufferedTransport(transport)
    protocal = TBinaryProtocol.TBinaryProtocol(transport)
    client = Hello.Client(protocal)
    transport.open()
    msg=client.helloWorld("peipei")
    print ("service response:"+ msg)
except Thrift.TException as ex:
    print ("%s" % (ex.message))
finally:
    transport.close()