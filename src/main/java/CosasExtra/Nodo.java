
package CosasExtra;


class Nodo implements Comparable<Nodo> {
        String nombre;
        int distancia;

        public Nodo(String nombre, int distancia) {
            this.nombre = nombre;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(Nodo otro) {
            return Integer.compare(this.distancia, otro.distancia);
        }
    }
