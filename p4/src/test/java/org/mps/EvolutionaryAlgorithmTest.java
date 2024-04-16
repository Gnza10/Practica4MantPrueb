package org.mps;

import org.junit.jupiter.api.BeforeEach;
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
