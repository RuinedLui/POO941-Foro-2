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
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 7);
    }

    private static int mostrarMenu() {
        String menu = "=== SISTEMA DE GESTIÓN DE VEHÍCULOS ===\n" +
                      "1. Registrar Automóvil\n" +
                      "2. Registrar Motocicleta\n" +
                      "3. Registrar Camión\n" +
                      "4. Mostrar todos los vehículos\n" +
                      "5. Mostrar vehículos por tipo\n" +
                      "6. Eliminar vehículo\n" +
                      "7. Salir\n" +
                      "Seleccione una opción:";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    private static void registrarAutomovil() {
        try {
            String codigo = JOptionPane.showInputDialog("Ingrese código del automóvil:");
            String marca = JOptionPane.showInputDialog("Ingrese marca:");
            String modelo = JOptionPane.showInputDialog("Ingrese modelo:");
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese año:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio:"));
            int puertas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de puertas:"));
            String combustible = JOptionPane.showInputDialog("Ingrese tipo de combustible:");

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
            String marca = JOptionPane.showInputDialog("Ingrese marca:");
            String modelo = JOptionPane.showInputDialog("Ingrese modelo:");
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese año:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio:"));
            int cilindraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cilindraje (cc):"));
            String tipo = JOptionPane.showInputDialog("Ingrese tipo de motocicleta (Deportiva/Crucero/etc):");

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
            String marca = JOptionPane.showInputDialog("Ingrese marca:");
            String modelo = JOptionPane.showInputDialog("Ingrese modelo:");
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese año:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio:"));
            double carga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese capacidad de carga (toneladas):"));
            int ejes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de ejes:"));

            Camion camion = new Camion(codigo, marca, modelo, anio, precio, carga, ejes);
            vehiculos.add(camion);
            JOptionPane.showMessageDialog(null, "Camión registrado exitosamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese datos numéricos válidos");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.WARNING_MESSAGE);
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
}