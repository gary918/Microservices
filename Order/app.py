# ------------------------------------------------------------
# Copyright (c) Microsoft Corporation.
# Licensed under the MIT License.
# ------------------------------------------------------------

import os
import requests
import time

dapr_port = os.getenv("DAPR_HTTP_PORT", 8081)
# dapr_url = "http://localhost:{}/v1.0/invoke/catalogue/method/listall".format(dapr_port)
# dapr_url = "http://localhost:8081/v1.0/invoke/catalogue/method/all"
dapr_url = "http://localhost:8081/listall"

print(dapr_url)

try:
    response = requests.get(dapr_url)
    print(response.status_code)
    print(response.text)
except Exception as e:
    print(e)
