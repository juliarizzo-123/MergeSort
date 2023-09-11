public class MergeSort {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Erro: Nenhum vetor de entrada fornecido.");
            return;
        }

        try {
            // Converte os argumentos de entrada em um vetor de inteiros
            int[] inputArray = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                inputArray[i] = Integer.parseInt(args[i]);
            }

            // Chama o algoritmo MergeSort para ordenar o vetor
            mergeSort(inputArray, 0, inputArray.length - 1);

            // Imprime o vetor ordenado
            for (int num : inputArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        } catch (NumberFormatException e) {
            System.err.println("Erro: Argumento de entrada não pode ser tratado como vetor.");
        }
    }

    // Implementação do algoritmo MergeSort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);     // Ordena a metade esquerda do vetor
            mergeSort(arr, middle + 1, right); // Ordena a metade direita do vetor
            merge(arr, left, middle, right);   // Combina as duas metades ordenadas
        }
    }

    // Função para mesclar duas partes ordenadas do vetor
    public static void merge(int[] arr, int left, int middle, int right) {
        // Calcula o tamanho das duas metades
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Cria vetores temporários para armazenar as duas metades
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copia os elementos das duas metades para os vetores temporários
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[middle + 1 + j];
        }

        // Mescla os dois vetores temporários de volta ao vetor original
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes, se houver, de leftArr para o vetor original
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copia os elementos restantes, se houver, de rightArr para o vetor original
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
