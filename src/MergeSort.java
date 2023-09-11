import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            // Solicita ao usuário o tamanho do array
            System.out.print("Digite o tamanho do array: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];

            // Solicita ao usuário os elementos do array separados por espaço e os armazena no array
            System.out.println("Digite os elementos do array separados por espaço:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Exibe o array original
            System.out.println("\nArray original: " + Arrays.toString(arr));
            // Chama a função mergeSort para ordenar o array
            mergeSort(arr, 0, arr.length - 1);
            // Exibe o array ordenado
            System.out.println("\nArray ordenado : " + Arrays.toString(arr));

            System.out.print("\nDeseja continuar (S/N)? ");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("S")) {
                continuar = false;
                }
        }
        scanner.close();
    }

    // Função recursiva para dividir o array e chamar a função merge
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid); // Ordena a metade esquerda do array
            mergeSort(arr, mid + 1, high); // Ordena a metade direita do array
            merge(arr, low, mid, high);// Combina as duas metades ordenadas
        }
    }

    // Função para mesclar duas partes ordenadas do array
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        // Combina os elementos das duas partes em ordem crescente
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes da primeira metade, se houver
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copia os elementos restantes da segunda metade, se houver
        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copia os elementos mesclados de volta para o array original
        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}
