```shell
$env:java_home

Get-ChildItem -Path Env:java_home

netstat -ano | findstr "10000"
netstat -ano | findstr ":10010"
netstat -ano | findstr ":9000"

tasklist | findstr "8240"

kill 8240

```