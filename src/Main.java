    import java.net.Inet4Address;
    import java.net.InetAddress;
    import java.net.Inet6Address;
    import java.net.UnknownHostException;
    import java.util.Scanner;


    public class Main{
        public static void main(String[] args){
            System.setProperty("java.net.preferIPv6Addresses", "true");
            try{


                System.out.println("IP local: " + InetAddress.getLocalHost());
                InetAddress local = InetAddress.getLocalHost();
                System.out.println("Mi equipo: " + local.getHostName());

            }catch (UnknownHostException e){
                System.err.println("ERROR: " + e.getMessage());
            }

            Scanner scanner = new Scanner(System.in);
            String dominio;
                do {
                    System.out.println("Introduce el dominio");
                    dominio = scanner.nextLine();
                    if (!dominio.equalsIgnoreCase("salir")) {
                        try {
                            for (InetAddress ip : InetAddress.getAllByName(dominio)) {
                                String tipo;
                                if(ip instanceof Inet4Address){
                                    tipo = "Ipv4";
                                } else if (ip instanceof  Inet6Address) {
                                    tipo = "IPv6";
                                } else{
                                    tipo = "Desconocido";
                                }
                                System.out.println(ip.getHostName() + " -> " + ip.getHostAddress() + " (" + tipo + ")");
                            }
                        }catch (UnknownHostException e){
                            System.err.println("ERROR" + e.getMessage());
                        }
                    }
                }while (!dominio.equalsIgnoreCase("salir"));
            System.out.println("Has salido");


        }
    }
