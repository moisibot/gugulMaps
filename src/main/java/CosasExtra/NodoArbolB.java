
package CosasExtra;


class NodoArbolB {
    int orden; 
    int numClaves; 
    int[] claves; 
    NodoArbolB[] hijos;
    boolean hojaNodo; 

    public NodoArbolB(int ordenArbol, boolean hojaInicial) {
        orden = ordenArbol;
        numClaves = 0;
        claves = new int[2 * orden - 1];
        hijos = new NodoArbolB[2 * orden];
        hojaNodo = hojaInicial;
    }
}

