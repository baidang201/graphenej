package com.luminiasoft.bitshares;

import java.util.Arrays;
import java.util.Base64;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.crypto.HDKeyDerivation;
import org.bitcoinj.crypto.MnemonicCode;

/**
 *
 * @author hvarona
 */
public class BIP39 {

    private ECKey mPrivateKey;

    public BIP39(String words, String passphrase) {

        byte[] seed = MnemonicCode.toSeed(Arrays.asList(words.split(" ")), passphrase);
        mPrivateKey = HDKeyDerivation.createMasterPrivateKey(seed);

    }

    public String getPublicKey() {
        return Base64.getEncoder().encodeToString(mPrivateKey.getPubKey());
    }

}