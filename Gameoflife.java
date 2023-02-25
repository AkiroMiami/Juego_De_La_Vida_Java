
public class Gameoflife {
    public static void main(String[] args) {
        /*
        Una célula muerta con exactamente 3 células vecinas vivas "nace" (es decir, al turno siguiente estará viva).
        Una célula viva con 2 o 3 células vecinas vivas sigue viva, en otro caso muere (por "soledad" o "superpoblación").
         */
        boolean tablero[][]=new boolean[10][10];
        genera(tablero);
        System.out.println("Generado");
        imprime(tablero);
        tablero=sigGeneracion(tablero);
        System.out.println("Siguiente Generación");
        imprime(tablero);
        tablero=sigGeneracion(tablero);                //aqui imprimimos las siguientes generaciones
        System.out.println("Siguiente Generación");
        imprime(tablero);
        tablero=sigGeneracion(tablero);
        System.out.println("Siguiente Generación");
        imprime(tablero);
        tablero=sigGeneracion(tablero);
        System.out.println("Siguiente Generación");
        imprime(tablero);
        tablero=sigGeneracion(tablero);
        System.out.println("Siguiente Generación");
        imprime(tablero);
        tablero=sigGeneracion(tablero);
        System.out.println("Siguiente Generación");
        imprime(tablero);



    }
    static boolean[][] sigGeneracion(boolean[][] original){
        boolean[][] siguiente=new boolean[original.length][original[0].length];
        for(int i=1;i<siguiente.length-1;i++){
            for(int j=1;j<siguiente[0].length-1;j++){
                int tot=0;
                if(original[i-1][j-1]) tot++;
                if(original[i][j-1]) tot++;
                if(original[i+1][j-1]) tot++;
                if(original[i-1][j]) tot++;
                if(original[i+1][j]) tot++;
                if(original[i-1][j+1]) tot++;         //aqui contamos las celulas vivas
                if(original[i][j+1]) tot++;
                if(original[i+1][j+1]) tot++;
                boolean vive=false;
                if(!original[i][j] && tot==3) vive=true;
                if(original[i][j] && (tot==3 || tot==2)) vive=true;
                siguiente[i][j]=vive;
            }
        }
        // esq 1
        int tot=0;
        boolean vive=false;
        if(original[1][1]) tot++;
        if(original[0][1]) tot++;
        if(original[1][0]) tot++;                       //aqui contamos las celulas vivas de las esquinas
        if(!original[0][0] && tot==3) vive=true;
        if(original[0][0] && (tot==3 || tot==2)) vive=true;
        siguiente[0][0]=vive;
        // esq 2
        tot=0;
        vive=false;
        int r=0;
        int c=original.length-1;
        if(original[r][c-1]) tot++;
        if(original[r+1][c-1]) tot++;
        if(original[r+1][c]) tot++;
        if(!original[0][0] && tot==3) vive=true;                 //aqui comprobamos si la celula vive o muere
        if(original[0][0] && (tot==3 || tot==2)) vive=true;
        siguiente[0][0]=vive;
        // esq 3
        tot=0;
        vive=false;
        r=original.length-1;
        c=0;
        if(original[r][c+1]) tot++;
        if(original[r-1][c]) tot++;                              //aqui comprobamos si la celula vive o muere
        if(original[r-1][c+1]) tot++;
        if(!original[0][0] && tot==3) vive=true;
        if(original[0][0] && (tot==3 || tot==2)) vive=true;
        siguiente[0][0]=vive;
        // esq 4
        tot=0;
        vive=false;
        r=original.length-1;
        c=original[0].length-1;
        if(original[r-1][c]) tot++;
        if(original[r-1][c-1]) tot++;
        if(original[r][c-1]) tot++;                              //aqui comprobamos si la celula vive o muere
        if(!original[0][0] && tot==3) vive=true;
        if(original[0][0] && (tot==3 || tot==2)) vive=true;
        siguiente[0][0]=vive;

        for(int i=1;i<original[0].length-2;i++){
            tot=0;
            vive=false;
            if(original[0][i-1]) tot++;
            if(original[0][i+1]) tot++;
            if(original[1][i-1]) tot++;                          //aqui comprobamos si la celula vive o muere
            if(original[1][i+1]) tot++;
            if(original[1][i]) tot++;
            if(!original[0][i] && tot==3) vive=true;
            if(original[0][i] && (tot==3 || tot==2)) vive=true;
            siguiente[0][i]=vive;
        }
        for(int i=1;i<original[0].length-2;i++){
            tot=0;
            vive=false;
            if(original[original.length-1][i-1]) tot++;
            if(original[original.length-1][i+1]) tot++;
            if(original[original.length-2][i-1]) tot++;
            if(original[original.length-2][i+1]) tot++;            //aqui comprobamos si la celula vive o muere
            if(original[original.length-2][i]) tot++;
            if(!original[original.length-1][i] && tot==3) vive=true;
            if(original[original.length-1][i] && (tot==3 || tot==2)) vive=true;
            siguiente[original.length-1][i]=vive;
        }

        for(int i=1;i<original.length-2;i++){
            tot=0;
            vive=false;
            if(original[i-1][0]) tot++;
            if(original[i+1][0]) tot++;
            if(original[i-1][1]) tot++;             //aqui comprobamos si la celula vive o muere
            if(original[i][1]) tot++;
            if(original[i+1][1]) tot++;
            if(!original[i][0] && tot==3) vive=true;
            if(original[i][0] && (tot==3 || tot==2)) vive=true;
            siguiente[i][0]=vive;
        }
        for(int i=1;i<original.length-2;i++){
            tot=0;
            vive=false;
            if(original[i-1][0]) tot++;
            if(original[i+1][0]) tot++;
            if(original[i-1][1]) tot++;
            if(original[i][1]) tot++;              //aqui comprobamos si la celula vive o muere
            if(original[i+1][1]) tot++;
            if(!original[i][0] && tot==3) vive=true;
            if(original[i][0] && (tot==3 || tot==2)) vive=true;
            siguiente[i][0]=vive;
        }

// se genera la nueva

        return siguiente;
    }
    static void imprime(boolean[][] temp){
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                System.out.print(temp[i][j]?"x ":"  ");       //aqui imprimimos la matriz
            }
            System.out.println();
        }
    }

    static void genera(boolean[][] temp){
        for(int i=0;i<temp.length;i++){         //aqui generamos la matriz
            for(int j=0;j<temp[0].length;j++){
                temp[i][j]=Math.random()<.5;
            }
        }
    }


}