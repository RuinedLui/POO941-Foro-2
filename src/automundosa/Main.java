import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarAutomovil();
                    break;
                case 2:
                    registrarMotocicleta();
                    break;
                case 3:
                    registrarCamion();
                    break;
                case 4:
                    mostrarTodos();
                    break;
                case 5:
                    mostrarPorTipo();
                    break;
                case 6:
                    eliminarVehiculo();
                    break;
                case 7:
                    contarVehiculos();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 8);
    }

    private static int mostrarMenu() {
        String menu = "=== SISTEMA DE GESTIÓN DE VEHÍCULOS ===\n" +
                "1. Registrar Automóvil\n" +
                "2. Registrar Motocicleta\n" +
                "3. Registrar Camión\n" +
                "4. Mostrar todos los vehículos\n" +
                "5. Mostrar vehículos por tipo\n" +
                "6. Eliminar vehículo\n" +
                "7. Contar vehículos registrados\n" +
                "8. Salir\n" +
                "Seleccione una opción:";

        String entrada = JOptionPane.showInputDialog(menu);

        if (entrada == null) return 8; 

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
            return 0;
        }
    }

    private static void registrarAutomovil() {
        try {
            String codigo = JOptionPane.showInputDialog("Ingrese código del automóvil:");
            if (codigo == null) return;

            String marca = JOptionPane.showInputDialog("Ingrese marca:");
            if (marca == null) return;

            String modelo = JOptionPane.showInputDialog("Ingrese modelo:");
            if (modelo == null) return;

            String anioStr = JOptionPane.showInputDialog("Ingrese año:");
            if (anioStr == null) return;
            int anio = Integer.parseInt(anioStr);

            String precioStr = JOptionPane.showInputDialog("Ingrese precio:");
            if (precioStr == null) return;
            double precio = Double.parseDouble(precioStr);

            String puertasStr = JOptionPane.showInputDialog("Ingrese cantidad de puertas:");
            if (puertasStr == null) return;
            int puertas = Integer.parseInt(puertasStr);

            String combustible = JOptionPane.showInputDialog("Ingrese tipo de combustible:");
            if (combustible == null) return;

            Automovil auto = new Automovil(codigo, marca, modelo, anio, precio, puertas, combustible);
            vehiculos.add(auto);
            JOptionPane.showMessageDialog(null, "Automóvil registrado exitosamente");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese datos numéricos válidos");
        }
    }

    private static void registrarMotocicleta() {
        try {
            String codigo = JOptionPane.showInputDialog("Ingrese código de la motocicleta:");
            if (codigo == null) return;

            String marca = JOptionPane.showInputDialog("Ingrese marca:");
            if (marca == null) return;

            String modelo = JOptionPane.showInputDialog("Ingrese modelo:");
            if (modelo == null) return;

            String anioStr = JOptionPane.showInputDialog("Ingrese año:");
            if (anioStr == null) return;
            int anio = Integer.parseInt(anioStr);

            String precioStr = JOptionPane.showInputDialog("Ingrese precio:");
            if (precioStr == null) return;
            double precio = Double.parseDouble(precioStr);

            String cilindrajeStr = JOptionPane.showInputDialog("Ingrese cilindraje (cc):");
            if (cilindrajeStr == null) return;
            int cilindraje = Integer.parseInt(cilindrajeStr);

            String tipo = JOptionPane.showInputDialog("Ingrese tipo de motocicleta (Deportiva/Crucero/etc):");
            if (tipo == null) return;

            Motocicleta moto = new Motocicleta(codigo, marca, modelo, anio, precio, cilindraje, tipo);
            vehiculos.add(moto);
            JOptionPane.showMessageDialog(null, "Motocicleta registrada exitosamente");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese datos numéricos válidos");
        }
    }

    private static void registrarCamion() {
        try {
            String codigo = JOptionPane.showInputDialog("Ingrese código del camión:");
            if (codigo == null) return;

            String marca = JOptionPane.showInputDialog("Ingrese marca:");
            if (marca == null) return;

            String modelo = JOptionPane.showInputDialog("Ingrese modelo:");
            if (modelo == null) return;

            String anioStr = JOptionPane.showInputDialog("Ingrese año:");
            if (anioStr == null) return;
            int anio = Integer.parseInt(anioStr);

            String precioStr = JOptionPane.showInputDialog("Ingrese precio:");
            if (precioStr == null) return;
            double precio = Double.parseDouble(precioStr);

            String cargaStr = JOptionPane.showInputDialog("Ingrese capacidad de carga (toneladas):");
            if (cargaStr == null) return;
            double carga = Double.parseDouble(cargaStr);

            String ejesStr = JOptionPane.showInputDialog("Ingrese cantidad de ejes:");
            if (ejesStr == null) return;
            int ejes = Integer.parseInt(ejesStr);

            Camion camion = new Camion(codigo, marca, modelo, anio, precio, carga, ejes);
            vehiculos.add(camion);
            JOptionPane.showMessageDialog(null, "Camión registrado exitosamente");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese datos numéricos válidos");
        }
    }
    
    private static void mostrarTodos() {
        if (vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados");
            return;
        }

        StringBuilder sb = new StringBuilder("=== LISTA DE TODOS LOS VEHÍCULOS ===\n\n");
        for (int i = 0; i < vehiculos.size(); i++) {
            sb.append("--- VEHÍCULO ").append(i + 1).append(" ---\n");
            sb.append(vehiculos.get(i).toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void mostrarPorTipo() {
        if (vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados");
            return;
        }

        String[] tipos = {"Automóviles", "Motocicletas", "Camiones"};
        int seleccion = JOptionPane.showOptionDialog(null,
                "Seleccione el tipo de vehículo a mostrar:",
                "Mostrar por tipo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]);

        if (seleccion == -1) return;

        String tipoSeleccionado = tipos[seleccion];
        StringBuilder sb = new StringBuilder("=== " + tipoSeleccionado.toUpperCase() + " ===\n\n");
        int contador = 0;

        for (Vehiculo v : vehiculos) {
            if ((seleccion == 0 && v instanceof Automovil) ||
                    (seleccion == 1 && v instanceof Motocicleta) ||
                    (seleccion == 2 && v instanceof Camion)) {
                contador++;
                sb.append("--- ").append(tipoSeleccionado.substring(0, tipoSeleccionado.length() - 1))
                        .append(" ").append(contador).append(" ---\n");
                sb.append(v.toString()).append("\n\n");
            }
        }

        if (contador == 0) {
            sb.append("No hay ").append(tipoSeleccionado.toLowerCase()).append(" registrados");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    private static void eliminarVehiculo() {
        if (vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados para eliminar");
            return;
        }

        String codigo = JOptionPane.showInputDialog("Ingrese el código del vehículo a eliminar:");
        if (codigo == null) return;

        boolean encontrado = false;
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                vehiculos.remove(i);
                encontrado = true;
                JOptionPane.showMessageDialog(null, "Vehículo eliminado exitosamente");
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró un vehículo con ese código");
        }
    }

    private static void contarVehiculos() {
        if (vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.");
            return;
        }

        int totalAutos = 0;
        int totalMotos = 0;
        int totalCamiones = 0;

        for (Vehiculo v : vehiculos) {
            if (v instanceof Automovil) {
                totalAutos++;
            } else if (v instanceof Motocicleta) {
                totalMotos++;
            } else if (v instanceof Camion) {
                totalCamiones++;
            }
        }

        String mensaje = "=== CONTEO DE VEHÍCULOS REGISTRADOS ===\n\n" +
                "🚗 Automóviles: " + totalAutos + "\n" +
                "🏍️ Motocicletas: " + totalMotos + "\n" +
                "🚛 Camiones: " + totalCamiones + "\n" +
                "─────────────────────\n" +
                "📊 TOTAL: " + vehiculos.size() + " vehículos";

        JOptionPane.showMessageDialog(null, mensaje);
    }
}
