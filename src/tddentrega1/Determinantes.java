package tddentrega1;

import java.util.Arrays;

public class Determinantes {
    public static double calcularDeterminantes(double[][] array) {
        if (array.length != 3 || Arrays.stream(array).anyMatch(a -> a.length != 3)) {
            throw new IllegalArgumentException("El array introducido no tiene las dimensiones correctas");
        }
        final double A = array[0][0];
        final double B = array[0][1];
        final double C = array[0][2];
        final double D = array[1][0];
        final double E = array[1][1];
        final double F = array[1][2];
        final double G = array[2][0];
        final double H = array[2][1];
        final double I = array[2][2];

        return (A * E * I + B * F * G + C * D * H) - (G * E * C + H * F * A + I * D * B);
    }

    public static double[] k(double[][] array) {
        final double A = array[0][0];
        final double B = array[0][1];
        final double C = array[0][2];
        final double D = array[1][0];
        final double E = array[1][1];
        final double F = array[1][2];
        final double G = array[2][0];
        final double H = array[2][1];
        final double I = array[2][2];
        final double J = array[0][3];
        final double K = array[1][3];
        final double L = array[2][3];

        double[][] a = {{A, B, C}, {D, E, F}, {G, H, I}};
        double[][] mX = {{J, B, C}, {K, E, F}, {L, H, I}};
        double[][] mY = {{A, J, C}, {D, K, F}, {G, L, I}};
        double[][] mZ = {{A, B, J}, {D, E, K}, {G, H, L}};

        System.out.println(calcularDeterminantes(mZ));
        System.out.println(calcularDeterminantes(a));

        return new double[]{calcularDeterminantes(mX) / calcularDeterminantes(a),
                calcularDeterminantes(mY) / calcularDeterminantes(a),
                calcularDeterminantes(mZ) / calcularDeterminantes(a)
        };
    }
}
