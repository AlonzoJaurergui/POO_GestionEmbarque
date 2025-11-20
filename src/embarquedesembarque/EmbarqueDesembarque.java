package embarquedesembarque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import pe.upn.poo.Vuelo;
import pe.upn.dao.VueloDao;

/**
 *
 * @author Alonzo
 */
public class EmbarqueDesembarque {

    static String opcion = "";
    static Scanner dato = new Scanner(System.in);
    static VueloDao dao = new VueloDao();
    
    public static void imprimevuelos(LinkedList<Vuelo> lvue) {
        for(Vuelo px : lvue) {
            px.listavuelos();
        }
    }
    static public void imprimeLinea(String caracter, int veces) {
        for (int i = 0; i < veces; i++) {
            System.out.print(caracter);
        }
        System.out.println("");
    }
    public static void agregaVuelos(){
   
        Vuelo v1 = new Vuelo();
        v1.setIdVuelo(1001);
        v1.setCodigoVuelo("LA2131");
        v1.setDestino("Lima");
        v1.setHoraSalida("02/08/2025 04:30");
        v1.setHoraEmbarque("02/08/2025 03:30");
        v1.setPuerta("A5");
        v1.setEstado("En vuelo");
        
        dao.create(v1);
        
        Vuelo fly = new Vuelo();                                                                
                               
        imprimeLinea("-", 40);
        System.out.println("REGISTRO DE UN NUEVO VUELO : ");
        imprimeLinea("-", 40);
        System.out.print("\nIngrese id \t: ");
        fly.setIdVuelo(Integer.parseInt(dato.nextLine()));                
        System.out.print("\nIngrese codigo \t: ");
        fly.setCodigoVuelo(dato.nextLine());
        System.out.print("Ingrese el destino \t: ");
        fly.setDestino(dato.nextLine());
        System.out.print("Ingrese la hora de embarque \t: ");
        fly.setHoraEmbarque(dato.nextLine());
        System.out.print("Ingrese la hora de salida del avion \t: ");
        fly.setHoraSalida(dato.nextLine());
        System.out.print("Ingrese la puerta de embarque \t: ");
        fly.setPuerta(dato.nextLine());
        fly.setEstado("Programado");
                
        dao.create(fly);   
    }
    public static void main(String[] args) throws IOException{ 
        int opcion;
        do {            
            System.out.println("\n#########SISTEMA DE CHECK-IN###########");
            System.out.println("1. Registro vuelo");
            System.out.println("2. Registro de pasajero");
            System.out.println("3. Registro Check-in");
            System.out.println("4. Listar vuelos");
            System.out.println("5. Buscar pasajero por dni");
            System.out.println("6. Eliminar pasajero por dni");
            System.out.println("7. Registro de equipaje");
            System.out.println("8. Salir");
            System.out.println("Opcion: ");            
            opcion= Integer.parseInt(dato.nextLine());
                        
            switch (opcion) {
                case 1:{
                    agregaVuelos();
                }break;
                case 2:{
                    
                }break;
                case 3:{
                    
                }break;
                case 4:{
                    imprimevuelos(dao.list());
                }break;
                case 5:{
                    
                }break;
                case 6:{
                    
                }break;
                case 7:{
                    
                }break;
                case 8:{
                    
                }break;
                default:
                    throw new AssertionError();
            }
        } while (true);
       /* do {
            System.out.print("Desea agregar un vuelo? (si/no) : ");
            opcion = dato.nextLine();
            if (opcion.equals("si")) {
              agregaVuelos();
              imprimeLinea("-", 40);
              System.out.println("VUELOS REGISTRADOS : ");
              imprimeLinea("-", 40);
              imprimevuelos(dao.list());
            }else if(opcion.equals("no")){
              System.out.print("Desea registrar un equipaje? (si/no) : ");
              opcion = dato.nextLine();
              if(opcion.equals("si")){
              }
            }
            
        } while (!opcion.equals("no"));
        */
       
    }
}
    

