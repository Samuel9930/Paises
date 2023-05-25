import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class PaisesMetodos {
	public void iniciar() {
		String menu="GESTION ESTUDIANTES\n";
		menu+="1. Registrar pais\n";
		menu+="2. Registrar ciudades\n";
		menu+="3. consultar ciudades por pais\n";
		menu+="4. consultar ciudad\n";
		menu+="5. Salir\n";
		menu+="Ingrese una opcion:\n";

		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(opc);
			
		} while (opc!=10);
	}
	HashMap<String, ArrayList> MapPaises = new HashMap<String, ArrayList>();
	
	public void validarMenu(int opc) {
		
		switch (opc) {
		case 1:
			 agregarPaises();
			 break;
		case 2:
			agregarCiudades();
		 	break;
		case 3:
			buscarCiudadesPorPaises();
		 	break;
		case 4:
			buscarCiudades();
			break;
		case 5:
			System.out.println("Chao!");
			break;
		
		default:
			System.out.println("Ingrese una opcion valida");
			break;
		}
	
	}
	public void agregarPaises() {
		String pais = JOptionPane.showInputDialog("Ingrese el nombre del pais");
		ArrayList<String> ciudad = new ArrayList<String>();
		MapPaises.put(pais, ciudad);
		System.out.println(MapPaises);
	}
	
	public void agregarCiudades() {
		int valid;
		String pais = JOptionPane.showInputDialog("Ingrese el pais donde desea registrar la ciudad");
		if(MapPaises.containsKey(pais)) {
			String city = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
			MapPaises.get(pais).add(city);
			
		}else {
			JOptionPane.showMessageDialog(null, "El pais no se encuentra registrado");
			valid = JOptionPane.showConfirmDialog(null, "¿Desea registrar el pais?");
			if(valid == 0) {
				agregarPaises();
			}else {
				agregarCiudades();
			}
		}
		System.out.println(MapPaises);
		
	}
	
	public void buscarCiudadesPorPaises(){
		int valid;
		String pais = JOptionPane.showInputDialog("Ingrese el pais donde desea consultar las ciudades");
		if(MapPaises.containsKey(pais)) {
			System.out.println("Ciudades de "+ pais + ":");
			 for (int i = 0; i < MapPaises.get(pais).size(); i++) {
				System.out.println(MapPaises.get(pais).get(i));
			}
		}else {
			JOptionPane.showMessageDialog(null, "El pais no se encuentra registrado");
			valid = JOptionPane.showConfirmDialog(null, "¿Desea registrar el pais?");
			if(valid == 0) {
				agregarPaises();
			}else {
				agregarCiudades();
			}
		}
	}
	
	public void buscarCiudades() {
	    String city = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad que desea consultar");
	    boolean found = false;
	    for (String pais : MapPaises.keySet()) {
	        if (MapPaises.get(pais).contains(city)) {
	            System.out.println(city + " pertenece a " + pais);
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println(city + " no se encuentra registrada en ningún país");
	    }
	}
}
