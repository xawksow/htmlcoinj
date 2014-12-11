/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bushstar.htmlcoinj.params;

import com.bushstar.htmlcoinj.core.NetworkParameters;
import com.bushstar.htmlcoinj.core.Sha256Hash;
import com.bushstar.htmlcoinj.core.Utils;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);
        dumpedPrivateKeyHeader = 168;
        addressHeader = 40;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = 6877;
        packetMagic= 0xa8a3a1a4L;
        genesisBlock.setDifficultyTarget(0x1e0fffffL);
        genesisBlock.setTime(1409500351L);
        genesisBlock.setNonce(0L);
        id = ID_MAINNET;
        subsidyDecreaseBlockCount = 900000000;
        spendableCoinbaseDepth = 500;
        String genesisHash = genesisBlock.getHashAsString();
	java.util.logging.Logger.getLogger("mytag").info("genesishash = " + genesisHash);
        checkState(genesisHash.equals("1f1af97f0962d248116bc139ba251646dac0a03eb5688feb5f999d7f52436dad"), genesisHash);

        dnsSeeds = new String[] {
                "seed.htmlcoin.net", "tnseed.htmlcoin.net"
        };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
