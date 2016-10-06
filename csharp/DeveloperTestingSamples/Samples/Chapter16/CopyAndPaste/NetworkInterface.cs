using Samples.Chapter16.CopyAndPaste.Domain.Networking;
using System.Net;

namespace Samples.Chapter16.CopyAndPaste
{
    // Illustrates constructor copy and paste.
    // This code is actually not in the book, only its Java counterpart.
    public class NetworkInterface
    {
        IPAddress ipAddress;
        NetMask netMask;
        IPAddress broadcast;
        IPAddress defaultRoute;

        IPAddress ipV6Address;
        NetMaskIpV6 ipV6NetMask;
        IPAddress ipV6DefaultRoute;

        public NetworkInterface(IPAddress ipAddress,
                                NetMask netMask,
                                IPAddress broadcast,
                                IPAddress defaultRoute)
        {
            this.ipAddress = ipAddress;
            this.netMask = netMask;
            this.broadcast = broadcast;
            this.defaultRoute = defaultRoute;
        }

        public NetworkInterface(IPAddress ipV6Address,
                                NetMaskIpV6 ipV6NetMask,
                                IPAddress ipV6DefaultRoute)
        {
            this.ipV6Address = ipV6Address;
            this.ipV6NetMask = ipV6NetMask;
            this.ipV6DefaultRoute = ipV6DefaultRoute;
        }

        public NetworkInterface(IPAddress ipAddress,
                                NetMask netMask,
                                IPAddress broadcast,
                                IPAddress defaultRoute,
                                IPAddress ipV6Address,
                                NetMaskIpV6 ipV6NetMask,
                                IPAddress ipV6DefaultRoute)
        {
            this.ipAddress = ipAddress;
            this.netMask = netMask;
            this.broadcast = broadcast;
            this.defaultRoute = defaultRoute;
            this.ipV6Address = ipV6Address;
            this.ipV6NetMask = ipV6NetMask;
            this.ipV6DefaultRoute = ipV6DefaultRoute;
        }
    }
}
