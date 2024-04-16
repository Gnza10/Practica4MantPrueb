package org.mps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.selection.SelectionOperator;
import org.mps.selection.TournamentSelection;
import org.mps.mutation.MutationOperator;
import org.mps.mutation.SwapMutation;
import org.mps.crossover.CrossoverOperator;
import org.mps.crossover.OnePointCrossover;
public class EvolutionaryAlgorithmTest {
    EvolutionaryAlgorithm ea;

    @BeforeEach
    public void setUp() {
        try {
            ea = new EvolutionaryAlgorithm(new TournamentSelection(4), new SwapMutation(),  new OnePointCrossover());
        } catch (EvolutionaryAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test de getMutationOperator")
    public void test_getMutationOperation(){
        SwapMutation swapMutation = new SwapMutation();
        EvolutionaryAlgorithm eaTest = null;
        try {
            eaTest = new EvolutionaryAlgorithm(new TournamentSelection(4), swapMutation,  new OnePointCrossover());
        } catch (EvolutionaryAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        MutationOperator expectedObject = swapMutation;

        MutationOperator actualObject = eaTest.getMutationOperator();

        assertEquals(expectedObject, actualObject);
    }

    @Test
    @DisplayName("Test de getSelectionOperator")
    public void test_getSelectionOperator(){
        TournamentSelection tournamentSelection = null;
        EvolutionaryAlgorithm eaTest = null;
        try {
            tournamentSelection = new TournamentSelection(4);
            eaTest = new EvolutionaryAlgorithm(tournamentSelection, new SwapMutation(),  new OnePointCrossover());
        } catch (EvolutionaryAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SelectionOperator expectedObject = tournamentSelection;

        SelectionOperator actualObject = eaTest.getSelectionOperator();

        assertEquals(expectedObject, actualObject);
    }

    @Test
    @DisplayName("Test de getCrossoverOperator")
    public void test_getCrossoverOperator(){
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        EvolutionaryAlgorithm eaTest = null;
        try {
            eaTest = new EvolutionaryAlgorithm(new TournamentSelection(4), new SwapMutation(),  onePointCrossover);
        } catch (EvolutionaryAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CrossoverOperator expectedObject = onePointCrossover;

        CrossoverOperator actualObject = eaTest.getCrossoverOperator();

        assertEquals(expectedObject, actualObject);
    }

    @Test
    @DisplayName("Test de optimize population es null")
    public void Test_OptimizePopulationNull_ReturnException(){
        int[][] population = null;
        assertThrows(EvolutionaryAlgorithmException.class, () -> ea.optimize(population));
    }

    @Test
    @DisplayName("Test de optimize cuando la primera fila de population tiene tamaño 0")
    public void Test_OptimizePopulationSize0_ReturnException(){
        int[][] population = {};
        assertThrows(EvolutionaryAlgorithmException.class, () -> ea.optimize(population));
    }

    @Test
    @DisplayName("Test de optimize cuando la primera fila de population es null")
    public void Test_OptimizeFila1Null_ReturnException(){
        int[][] population = {null,{2}};
        assertThrows(EvolutionaryAlgorithmException.class, () -> ea.optimize(population));
    }

    @Test
    @DisplayName("Test de optimize cuando la primera fila de population tiene tamaño 0")
    public void Test_OptimizeFila1Size0_ReturnException(){
        int[][] population = {{},{2}};
        assertThrows(EvolutionaryAlgorithmException.class, () -> ea.optimize(population));
    }
}
