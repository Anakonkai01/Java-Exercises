public class Exercise2{
    // 2a
    //check size of matrix 
    
    public static int[][] addMatrix(int m1[][],int m2[][]){
        //check size of matrix
        if(m1.length != m2.length || m1[0].length != m2[0].length){
            System.out.println("Matrix not equal");
            return null;
        }
        int[][] returnMatrix = new int[m1.length][m1[0].length];
        
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[0].length;j++){
                returnMatrix[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return returnMatrix;
    }
    
    // 2b
    public static int[][] multiplyMatrix(int m1[][],int m2[][]){
        //check size of matrix
        if(m1[0].length != m2.length){
            System.out.println("Multiplication not possible");
            return null;
        }
        int[][] returnMatrix = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    returnMatrix[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return returnMatrix;
    }

    // print
    public static void printMatrix(int m[][]){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int [][] m1 = {{1,2,3},{4,5,6}};
        int [][] m2 = {{7,8,9},{10,11,12}};
        int [][] m3 = {{7,8},{9,10},{11,12}};

        //2a
        System.out.println("2a:");
        int[][] returnMatrix = addMatrix(m1, m2);
        System.out.println("Matrix A:");
        printMatrix(m1);
        System.out.println("'+'");
        System.out.println("Matrix B:");
        printMatrix(m2);
        System.out.println("=");
        printMatrix(returnMatrix);

        //2b
        System.out.println();
        System.out.println("2b:");
        returnMatrix = multiplyMatrix(m1, m3);
        System.out.println("Matrix A:");
        printMatrix(m1);
        System.out.println("'*'");
        System.out.println("Matrix B:");
        printMatrix(m3);
        System.out.println("=");
        printMatrix(returnMatrix);

        
    }
}

