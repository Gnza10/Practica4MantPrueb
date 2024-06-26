package org.mps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test de constructor")
    public void testConstructor_NotNull() {
        SwapMutation sm = new SwapMutation();
        OnePointCrossover opc = new OnePointCrossover();
        TournamentSelection ts;
        try {
            ts = new TournamentSelection(4);

            EvolutionaryAlgorithm ea = new EvolutionaryAlgorithm(ts, sm, opc);

            assertNotNull(ea);
        } catch (EvolutionaryAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test de Constructor con TournamentSelection null")
    public void testConstructor_TournamentSelectionNull() {
        SwapMutation sm = new SwapMutation();
        OnePointCrossover opc = new OnePointCrossover();
        TournamentSelection ts = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            EvolutionaryAlgorithm ea = new EvolutionaryAlgorithm(ts, sm, opc);
        });
    }

    @Test
    @DisplayName("Test de Constructor con SwapMutation null")
    public void testConstructor_SwapMutationNull() {
        SwapMutation sm = null;
        OnePointCrossover opc = new OnePointCrossover();
        TournamentSelection ts;
        try {
            ts = new TournamentSelection(4);

            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                EvolutionaryAlgorithm ea = new EvolutionaryAlgorithm(ts, sm, opc);
            });
        } catch (EvolutionaryAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test de Constructor con OnePointCrossover null")
    public void testConstructor_OnePointCrossoverNull() {
        SwapMutation sm = new SwapMutation();
        OnePointCrossover opc = null;
        TournamentSelection ts;
        try {
            ts = new TournamentSelection(4);

            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                EvolutionaryAlgorithm ea = new EvolutionaryAlgorithm(ts, sm, opc);
            });
        } catch (EvolutionaryAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test de setMutationOperator")
    public void test_SetMutationOperator_ReturnsOperator() {
        SwapMutation sm = new SwapMutation();
        ea.setMutationOperator(sm);

        assertNotNull(ea.getMutationOperator());
    }

    @Test
    @DisplayName("Test de setSelectionOperator")
    public void test_SetSelectionOperator_ReturnOperator() {
        TournamentSelection sm;
        try {
            sm = new TournamentSelection(4);

            ea.setSelectionOperator(sm);
        } catch (EvolutionaryAlgorithmException e) {
            
            e.printStackTrace();
        }
        assertNotNull(ea.getMutationOperator());
    }

    @Test
    @DisplayName("Test de setCrossOverOperator")
    public void testSetCrossOverOperation_Returnsoperator() {
        OnePointCrossover opc = new OnePointCrossover();
        ea.setCrossoverOperator(opc);

        assertNotNull(ea.getCrossoverOperator());
    }
  
  @Test
    @DisplayName("Test de getMutationOperator")
    public void test_getMutationOperation(){
        SwapMutation swapMutation = new SwapMutation();
        EvolutionaryAlgorithm eaTest = null;
        try {
            eaTest = new EvolutionaryAlgorithm(new TournamentSelection(4), swapMutation,  new OnePointCrossover());
        } catch (EvolutionaryAlgorithmException e) {
            
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
            
            e.printStackTrace();
        }
        TournamentSelection expectedObject = tournamentSelection;

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
            
            e.printStackTrace();
        }
        CrossoverOperator expectedObject = onePointCrossover;

        CrossoverOperator actualObject = eaTest.getCrossoverOperator();

        assertEquals(expectedObject, actualObject);
    }

    @Test
    @DisplayName("Test de optimize correcto")
    public void testOptimize_Correct() {
        int[][] population = { { 8, 4, 3, 4 }, { 5, 6, 7, 8 }};
        
        int[][] result;
        try {
            result = ea.optimize(population);

            assertEquals(population.length, result.length);
        } catch (EvolutionaryAlgorithmException e) {
            
            e.printStackTrace();
        }        
    }

    @Test
    @DisplayName("Test de optimize correcto")
    public void testOptimize_Correct2() {
        int[][] population = { { 5, 6, 7, 8 }, { 8, 4, 3, 4 }};
        
        int[][] result;
        try {
            result = ea.optimize(population);

            assertEquals(population.length, result.length);
        } catch (EvolutionaryAlgorithmException e) {
            
            e.printStackTrace();
        }        
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

    @Nested
    @DisplayName("Tests de los operadores")
    public class tests_Selectores{
        @Test
        @DisplayName("Test de tournamentSelection con población 0")
        public void testSelectionConstructor_EmptyPopulation_ReturnException() {
            int[][] population = {};
            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.setSelectionOperator(new TournamentSelection(0)));
        }

        @Test
        @DisplayName("Test de seleccionar con población null")
        public void testSelection_NullPopulation_ReturnException() {
            int[] population = null;
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.getSelectionOperator().select(population));
        }

        @Test
        @DisplayName("Test de seleccionar con población vacía")
        public void testSelection_EmptyPopulation_ReturnException() {
            int[] population = {};
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.getSelectionOperator().select(population));
        }

        @Test
        @DisplayName("Test de mutar con población nula")
        public void testMutation_NullPopulation_ReturnException() {
            int[] population = null;

            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.getMutationOperator().mutate(population));
        }

        @Test
        @DisplayName("Test de mutar con población vacía")
        public void testMutation_EmptyPopulation_ReturnException() {
            int[] population = {};

            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.getMutationOperator().mutate(population));
        }

        @Test
        @DisplayName("Test de crossover con población nula en el primer padre")
        public void testCrossover_NullPopulation1_ReturnException() {
            int[] parent1 = null;
            int[] parent2 = {1, 2, 3, 4};

            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.getCrossoverOperator().crossover(parent1, parent2));
        }

        @Test
        @DisplayName("Test de crossover con población nula en el segundo padre")
        public void testCrossover_NullPopulation2_ReturnException() {
            int[] parent1 = {1, 2, 3, 4};
            int[] parent2 = null;

            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.getCrossoverOperator().crossover(parent1, parent2));
        }

        @Test
        @DisplayName("Test de crossover con población vacía en el primer padre")
        public void testCrossover_EmptyPopulation1_ReturnException() {
            int[] parent1 = {};
            int[] parent2 = {1, 2, 3, 4};

            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.getCrossoverOperator().crossover(parent1, parent2));
        }

        @Test
        @DisplayName("Test de crossover con población del primer padre de longitud no igual a la del segundo")
        public void testCrossover_Population1SizeEqualsPopulation2Size_ReturnException() {
            int[] parent1 = {1, 2, 3, 4};
            int[] parent2 = {1, 2, 3, 4,5};

            assertThrows(EvolutionaryAlgorithmException.class, () -> ea.getCrossoverOperator().crossover(parent1, parent2));
        }
    }
}
