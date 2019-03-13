# Octopus
> A spring boot app

## Getting started

Run Vault on docker:

```shell
docker container run -p 8200:8200 --name vault -e 'VAULT_DEV_ROOT_TOKEN_ID=ROOT_TOKEN' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' vault
```
Authenticate to vault:

```shell
docker exec -i -t vault sh
export VAULT_ADDR='http://localhost:8200'
vault auth ROOT_TOKEN
```