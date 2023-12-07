public class ProgramaArbolBinario {

	public static void main(String[] args) {
		ABB arbol = new ABB();
		arbol.insertarNodo(50, arbol.regresaRaiz());
		arbol.insertarNodo(30, arbol.regresaRaiz());
		arbol.insertarNodo(70, arbol.regresaRaiz());
		arbol.insertarNodo(20, arbol.regresaRaiz());
		arbol.insertarNodo(40, arbol.regresaRaiz());
		arbol.insertarNodo(60, arbol.regresaRaiz());
		arbol.insertarNodo(80, arbol.regresaRaiz());
	
		System.out.println("Arbol Horizontal:");
		arbol.imprimirArbolHorizontal();
		System.out.println();
	
		
		int valorBuscado = 60;
		Nodo nodoBuscado = arbol.buscarNodo(valorBuscado);
		if (nodoBuscado != null) {
			System.out.println("Nodo encontrado: " + nodoBuscado.dato);
		} else {
			System.out.println("Nodo no encontrado: " + valorBuscado);
		}
	
		// Recorrer en preorden
		System.out.println("Arbol en preorden:");
		arbol.recorrerPreorden(arbol.regresaRaiz());
		System.out.println();
	
		// Recorrer en inorden
		System.out.println("Arbol en inorden:");
		arbol.recorrerInorden(arbol.regresaRaiz());
		System.out.println();
	
		// Recorrer en postorden
		System.out.println("Arbol en postorden:");
		arbol.recorrerPostorden(arbol.regresaRaiz());
		System.out.println();
	
	
		int valorEliminar = 30;
		arbol.eliminarNodo(valorEliminar);
		System.out.println("Arbol después de eliminar el nodo con valor " + valorEliminar + ":");
		arbol.imprimirArbolHorizontal();
	}
}
