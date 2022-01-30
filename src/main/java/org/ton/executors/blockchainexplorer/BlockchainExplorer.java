package org.ton.executors.blockchainexplorer;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.ton.settings.Node;

import java.util.concurrent.Future;

@Slf4j
public class BlockchainExplorer {

    public static final String MY_LOCAL_TON = "myLocalTon";

    public Process startBlockchainExplorer(Node node, String globalConfigFile, int port) {
        log.info("blockchain-explorer started with {} at  {}", globalConfigFile, node.getPublicIp() + ":" + node.getDhtPort());
        Pair<Process, Future<String>> blockchainExplorerExecutor = new BlockchainExplorerExecutor().execute(node,
                // "-v", Utils.getTonLogLevel(MyLocalTon.getInstance().getSettings().getLogSettings().getTonLogLevel()),
                "-v", "4",
                "-C", globalConfigFile,
                "-H", String.valueOf(port));
        // "-a", node.getPublicIp() + ":" + node.getLiteServerPort());
        node.setBlockchainExplorerProcess(blockchainExplorerExecutor.getLeft());
        return blockchainExplorerExecutor.getLeft();
    }
}