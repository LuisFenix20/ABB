public class ABB {

    private Nodo raiz;

    ABB() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public Nodo regresaRaiz() {
        return this.raiz;
    }

    public void insertarNodo(int valor, Nodo nodoRef) {
        this.raiz = insertar(valor, nodoRef);
    }

    private Nodo insertar(int valor, Nodo nodo) {
        if (nodo == null) {
            nodo = new Nodo();
            nodo.dato = valor;
            nodo.izquierdo = null;
            nodo.derecho = null;
        } else {
            if (valor <= nodo.dato) {
                nodo.izquierdo = insertar(valor, nodo.izquierdo);
            } else {
                nodo.derecho = insertar(valor, nodo.derecho);
            }
        }
        return nodo;
    }

    public void imprimirArbolHorizontal() {
        imprimirArbol(raiz, 0, "");
    }
    //imprimir arbol horizontal
    private void imprimirArbol(Nodo nodo, int nivel, String prefijo) {
        if (nodo != null) {
            imprimirArbol(nodo.derecho, nivel + 1, prefijo + "    ");
    
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
    
            System.out.println(prefijo + nodo.dato);
    
            imprimirArbol(nodo.izquierdo, nivel + 1, prefijo + "    ");
        }
    }
   

    public Nodo buscarNodo(int valor) {
        return buscar(raiz, valor);
    }
  //Buscar nodo
    private Nodo buscar(Nodo nodo, int valor) {
        if (nodo == null || nodo.dato == valor) {
            return nodo;
        }

        if (valor < nodo.dato) {
            return buscar(nodo.izquierdo, valor);
        } else {
            return buscar(nodo.derecho, valor);
        }
    }

    public void recorrerPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            recorrerPreorden(nodo.izquierdo);
            recorrerPreorden(nodo.derecho);
        }
    }
    

    public void recorrerInorden(Nodo nodo) {
        if (nodo != null) {
            recorrerInorden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            recorrerInorden(nodo.derecho);
        }
    }

    

    public void recorrerPostorden(Nodo nodo) {
        if (nodo != null) {
            recorrerPostorden(nodo.izquierdo);
            recorrerPostorden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

   

    public void eliminarNodo(int valor) {
        this.raiz = eliminar(raiz, valor);
    }

    //eliminar nodo

    private Nodo eliminar(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.dato) {
            nodo.izquierdo = eliminar(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = eliminar(nodo.derecho, valor);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            nodo.dato = encontrarMinimoValor(nodo.derecho);
            nodo.derecho = eliminar(nodo.derecho, nodo.dato);
        }

        return nodo;
    }

    private int encontrarMinimoValor(Nodo nodo) {
        int minimoValor = nodo.dato;
        while (nodo.izquierdo != null) {
            minimoValor = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return minimoValor;
    }
}
