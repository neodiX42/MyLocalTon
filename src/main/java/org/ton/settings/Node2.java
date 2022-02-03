package org.ton.settings;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ton.utils.Extractor;
import org.ton.wallet.WalletAddress;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.ton.settings.MyLocalTonSettings.CURRENT_DIR;

@Getter
@Setter
@ToString
public class Node2 implements Serializable, Node {

    private static final long serialVersionUID = 1L;
    public static final String MY_LOCAL_TON = "myLocalTon";

    String nodeName = "node2";
    String publicIp = "127.0.0.2";
    Integer consolePort = 4444;
    Integer publicPort = 4445;
    Integer liteServerPort = 4446;
    Integer dhtPort = 6303;
    Integer dhtForkedPort = 6383;
    Integer dhtOutPort = 3272;
    Integer dhtForkedOutPort = 3282;
    Integer outPort = 3272;
    Long initialStake = 20L;
    String validatorMonitoringPubKeyHex;
    String validatorMonitoringPubKeyInteger;
    String validatorPrvKeyHex;
    String validatorPrvKeyBase64;
    String validatorPubKeyHex;
    String validatorPubKeyBase64;
    String validatorAdnlAddrHex;

    String validationSigningKey;
    String validationSigningPubKey;
    String validationAndlKey;
    String validationPubKeyHex;
    String validationPubKeyInteger;
    Boolean validationParticipated = Boolean.FALSE;
    Boolean validationPubKeyAndAdnlCreated = Boolean.FALSE;

    WalletAddress walletAddress;
    transient Process nodeProcess;
    transient Process dhtServerProcess;
    transient Process blockchainExplorerProcess;
    String nodeGlobalConfigLocation = getTonDbDir() + "my-ton-global.config.json";
    String nodeForkedGlobalConfigLocation = getTonDbDir() + "my-ton-forked.config.json";

    @Override
    public String getTonDbDir() {
        return CURRENT_DIR + File.separator + MY_LOCAL_TON + File.separator + nodeName + File.separator + "db" + File.separator;
    }

    @Override
    public String getTonBinDir() {
        return CURRENT_DIR + File.separator + MY_LOCAL_TON + File.separator + nodeName + File.separator + "bin" + File.separator;
    }

    @Override
    public String getTonLogDir() {
        return CURRENT_DIR + File.separator + MY_LOCAL_TON + File.separator + nodeName + File.separator + "db" + File.separator + "log" + File.separator;
    }

    @Override
    public String getTonDbKeyringDir() {
        return CURRENT_DIR + File.separator + MY_LOCAL_TON + File.separator + nodeName + File.separator + "db" + File.separator + "keyring" + File.separator;
    }

    @Override
    public String getTonDbStaticDir() {
        return CURRENT_DIR + File.separator + MY_LOCAL_TON + File.separator + nodeName + File.separator + "db" + File.separator + "static" + File.separator;
    }

    @Override
    public String getDhtServerDir() {
        return CURRENT_DIR + File.separator + MY_LOCAL_TON + File.separator + nodeName + File.separator + "db" + File.separator + "dht-server" + File.separator;
    }

    @Override
    public String getDhtServerKeyringDir() {
        return getDhtServerDir() + "keyring" + File.separator;
    }

    @Override
    public String getTonCertsDir() {
        return getTonBinDir() + File.separator + "certs" + File.separator;
    }

    @Override
    public String getValidatorKeyPubLocation() {
        return getTonBinDir() + "smartcont" + File.separator + "validator-keys-2.pub";
    }

    @Override
    public String getNodeGlobalConfigLocation() {
        return getTonDbDir() + "my-ton-global.config.json";
    }

    @Override
    public String getNodeForkedGlobalConfigLocation() {
        return getTonDbDir() + "my-ton-forked.config.json";
    }

    @Override
    public void extractBinaries() throws IOException {
        new Extractor(nodeName);
        Files.createDirectories(Paths.get(getTonDbDir()));
        Files.createDirectories(Paths.get(getTonDbKeyringDir()));
        Files.createDirectories(Paths.get(getTonDbStaticDir()));
    }

    @Override
    public String getGenesisGenZeroStateFifLocation() {
        return CURRENT_DIR + File.separator + MY_LOCAL_TON + File.separator + "genesis" + File.separator + "bin" + File.separator + "smartcont" + File.separator + "gen-zerostate.fif";
    }
}
