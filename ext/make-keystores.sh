#!/bin/sh
set -x
set -e
# expects a relative pcp-broker checkout
# drops keystores in src/test/resources

keytool -importcert \
        -file ../pcp-broker/test-resources/ssl/ca/ca_crt.pem \
        -storepass foobarbaz \
        -keystore src/test/resources/truststore.ks \
        -noprompt

cat ../pcp-broker/test-resources/ssl/private_keys/client01.example.com.pem \
    ../pcp-broker/test-resources/ssl/certs/client01.example.com.pem  > combined.pem

openssl pkcs12 \
        -export \
        -in combined.pem \
        -out client01.example.com.p12 \
        -name client01.example.com \
        -passout pass:foobarbaz

keytool -importkeystore \
        -storepass foobarbaz \
        -destkeystore src/test/resources/keystore.ks \
        -srckeystore client01.example.com.p12 \
        -srcstorepass foobarbaz \
        -srcstoretype PKCS12 \
        -alias client01.example.com \
        -noprompt

rm combined.pem
rm client01.example.com.p12
