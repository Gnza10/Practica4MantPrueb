package org.mps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.selection.TournamentSelection;
import org.mps.mutation.SwapMutation;
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertNotNull(ea.getMutationOperator());
    }

    @Test
    @DisplayName("Test de stCrossOverOperator")
    public void testSetCrossOverOperation_Returnsoperator() {
        OnePointCrossover opc = new OnePointCrossover();
        ea.setCrossoverOperator(opc);

        assertNotNull(ea.getCrossoverOperator());
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }

}
