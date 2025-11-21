package embarquedesembarque;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import pe.upn.dao.EquipajeDao;
import pe.upn.dao.PasajeroDao;
import pe.upn.dao.VueloDao;
import pe.upn.poo.Administrador;
import pe.upn.poo.Embarque;
import pe.upn.poo.Equipaje;
import pe.upn.poo.Pasajero;
import pe.upn.poo.Vuelo;

public class EmbarqueDesembarque {

    static Scanner dato = new Scanner(System.in);
    static VueloDao dao = new VueloDao();
    static PasajeroDao pasajeroDao = new PasajeroDao();
    static EquipajeDao equipajeDao = new EquipajeDao();
    static Administrador admin = new Administrador(1, "admin", "admin123");
    static Embarque embarque = new Embarque(1, ""); // fechaHora opcional
    static boolean datosInicialesCargados = false;

    public static void imprimevuelos(LinkedList<Vuelo> lvue) {
        if (lvue.isEmpty()) {
            System.out.println("No hay vuelos registrados.");
            return;
        }
        for (Vuelo px : lvue) px.listavuelos();
    }

    static public void imprimeLinea(String caracter, int veces) {
        for (int i = 0; i < veces; i++) System.out.print(caracter);
        System.out.println("");
    }

    public static void cargarDatosIniciales(){
        if (datosInicialesCargados) return;
        Vuelo v1 = new Vuelo();
        v1.setIdVuelo(1001);
        v1.setCodigoVuelo("LA2131");
        v1.setDestino("Lima");
        v1.setHoraSalida("02/08/2025 04:30");
        v1.setHoraEmbarque("02/08/2025 03:30");
        v1.setPuerta("A5");
        v1.setEstado("Programado");
        admin.registrarVuelo(v1, dao);

        Vuelo v2 = new Vuelo();
        v2.setIdVuelo(1002);
        v2.setCodigoVuelo("AV450");
        v2.setDestino("Cusco");
        v2.setHoraSalida("05/08/2025 12:00");
        v2.setHoraEmbarque("05/08/2025 11:00");
        v2.setPuerta("B2");
        v2.setEstado("Programado");
        admin.registrarVuelo(v2, dao);

        datosInicialesCargados = true;
    }

    public static void agregaVuelos(){
        try {
            imprimeLinea("-", 40);
            System.out.println("REGISTRO DE UN NUEVO VUELO : ");
            imprimeLinea("-", 40);
            Vuelo fly = new Vuelo();
            System.out.print("Ingrese id \t: ");
            fly.setIdVuelo(Integer.parseInt(dato.nextLine()));
            System.out.print("Ingrese codigo \t: ");
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

            admin.registrarVuelo(fly, dao);
            System.out.println("Vuelo registrado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error al registrar vuelo: " + ex.getMessage());
        }
    }

    public static void registrarPasajero() {
        try {
            System.out.println("--- LISTA DE VUELOS ---");
            imprimevuelos(dao.list());
            System.out.print("Ingrese ID del vuelo donde registrará al pasajero: ");
            int id = Integer.parseInt(dato.nextLine());
            Vuelo vuelo = dao.findById(id);
            if (vuelo == null) {
                System.out.println("Vuelo no encontrado con id: " + id);
                return;
            }

            System.out.print("Ingrese id pasajero: ");
            int idp = Integer.parseInt(dato.nextLine());
            System.out.print("Ingrese nombre pasajero: ");
            String nombre = dato.nextLine();
            System.out.print("Ingrese DNI pasajero: ");
            String dni = dato.nextLine();

            // evitar dni duplicado en el mismo vuelo
            if (vuelo.buscarPasajeroPorDni(dni) != null) {
                System.out.println("Ya existe un pasajero con ese DNI en este vuelo.");
                return;
            }

            Pasajero p = new Pasajero(idp, nombre, dni, "Pendiente");
            vuelo.agregarPasajero(p);
            pasajeroDao.create(p);
            System.out.println("Pasajero registrado en el vuelo " + vuelo.getCodigoVuelo());
        } catch (Exception ex) {
            System.out.println("Error registrando pasajero: " + ex.getMessage());
        }
    }

    public static void registrarCheckIn() {
        try {
            System.out.print("Ingrese DNI del pasajero para check-in: ");
            String dni = dato.nextLine();
            Vuelo vuelo = dao.findVueloByPasajeroDni(dni);
            if (vuelo == null) {
                System.out.println("Pasajero no encontrado en ningún vuelo con DNI: " + dni);
                return;
            }
            Pasajero p = vuelo.buscarPasajeroPorDni(dni);
            if (p == null) {
                System.out.println("Error interno: pasajero no encontrado en vuelo.");
                return;
            }
            boolean ok = embarque.confirmarEmbarque(p, vuelo);
            if (ok) {
                System.out.println("Check-in realizado. Pasajero " + p.getNombre() + " ahora está: " + p.getEstadoEmbarque());
            } else {
                System.out.println("No se pudo realizar el check-in (ticket inválido o estado).");
            }
        } catch (Exception ex) {
            System.out.println("Error en check-in: " + ex.getMessage());
        }
    }

    public static void buscarPasajeroPorDni() {
        System.out.print("Ingrese DNI a buscar: ");
        String dni = dato.nextLine();
        Vuelo vuelo = dao.findVueloByPasajeroDni(dni);
        if (vuelo == null) {
            System.out.println("No se encontró pasajero con DNI: " + dni);
            return;
        }
        Pasajero p = vuelo.buscarPasajeroPorDni(dni);
        System.out.println("Pasajero encontrado en el vuelo: " + vuelo.getCodigoVuelo());
        System.out.println(p.toString());
        System.out.println("Equipajes:");
        p.listarEquipajes();
    }

    public static void eliminarPasajeroPorDni() {
        System.out.print("Ingrese DNI del pasajero a eliminar: ");
        String dni = dato.nextLine();
        boolean eliminadoEnVuelo = dao.eliminarPasajeroGlobalPorDni(dni);
        boolean eliminadoEnDao = pasajeroDao.deleteByDni(dni);
        if (eliminadoEnVuelo || eliminadoEnDao) {
            System.out.println("Pasajero con DNI " + dni + " eliminado.");
        } else {
            System.out.println("No se encontró pasajero con DNI " + dni);
        }
    }

    public static void registrarEquipaje() {
        try {
            System.out.print("Ingrese DNI del pasajero para registrar equipaje: ");
            String dni = dato.nextLine();
            Vuelo vuelo = dao.findVueloByPasajeroDni(dni);
            if (vuelo == null) {
                System.out.println("Pasajero no encontrado con DNI: " + dni);
                return;
            }
            Pasajero p = vuelo.buscarPasajeroPorDni(dni);
            System.out.print("Ingrese id equipaje: ");
            int ideq = Integer.parseInt(dato.nextLine());
            System.out.print("Ingrese peso (kg): ");
            double peso = Double.parseDouble(dato.nextLine());
            System.out.print("Ingrese tipo (Mano/Bodega): ");
            String tipo = dato.nextLine();
            Equipaje eq = new Equipaje(ideq, peso, tipo);
            equipajeDao.create(eq);
            admin.registrarEquipaje(eq, p);
            System.out.println("Equipaje registrado para pasajero " + p.getNombre());
        } catch (Exception ex) {
            System.out.println("Error registrando equipaje: " + ex.getMessage());
        }
    }
    
    public static void consultarVueloYEquipaje() {
        try {
            System.out.print("Ingrese DNI del pasajero: ");
            String dni = dato.nextLine().trim();
            if (dni.isEmpty()) {
                System.out.println("DNI no puede estar vacío.");
                return;
            }

            // Encontrar vuelo por DNI
            Vuelo vuelo = dao.findVueloByPasajeroDni(dni);
            if (vuelo == null) {
                System.out.println("No se encontró pasajero con DNI: " + dni);
                return;
            }

            // Obtener pasajero
            Pasajero p = vuelo.buscarPasajeroPorDni(dni);
            if (p == null) {
                System.out.println("Error interno: pasajero no está dentro del vuelo.");
                return;
            }

            // Mostrar datos del pasajero
            System.out.println("\n===== DATOS DEL PASAJERO =====");
            System.out.println("Nombre : " + p.getNombre());
            System.out.println("DNI    : " + p.getDni());
            System.out.println("Estado : " + p.getEstadoEmbarque());

            // Mostrar datos del vuelo
            System.out.println("\n===== DATOS DEL VUELO =====");
            System.out.println("ID      : " + vuelo.getIdVuelo());
            System.out.println("Codigo  : " + vuelo.getCodigoVuelo());
            System.out.println("Destino : " + vuelo.getDestino());
            System.out.println("H. Embarque : " + vuelo.getHoraEmbarque());
            System.out.println("H. Salida   : " + vuelo.getHoraSalida());
            System.out.println("Puerta      : " + vuelo.getPuerta());
            System.out.println("Estado vuelo: " + vuelo.getEstado());

            // Equipaje
            System.out.println("\n===== EQUIPAJE REGISTRADO =====");
            p.listarEquipajes();

        } catch (Exception ex) {
            System.out.println("Error al consultar vuelo y equipaje: " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        cargarDatosIniciales();

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
            System.out.println("8. Consultar vuelo y equipaje del pasajero");
            System.out.println("9. Salir");
            System.out.print("Opcion: ");
            try {
                opcion = Integer.parseInt(dato.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese una opción numérica válida.");
                continue;
            }

            switch (opcion) {
                case 1 -> agregaVuelos();
                case 2 -> registrarPasajero();
                case 3 -> registrarCheckIn();
                case 4 -> imprimevuelos(dao.list());
                case 5 -> buscarPasajeroPorDni();
                case 6 -> eliminarPasajeroPorDni();
                case 7 -> registrarEquipaje();
                case 8 -> consultarVueloYEquipaje();
                case 9 -> {
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (true);
    }
}
    

