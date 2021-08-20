import requests
from flask import Flask

app = Flask(__name__)
@app.route('/order', methods=['GET', 'POST'])
def welcome():
    dapr_url = "http://localhost:3500/v1.0/invoke/catalogue/method/listall"

    print(dapr_url)

    try:
        response = requests.get(dapr_url)
        print(response.status_code)
        print(response.text)
    except Exception as e:
        print(e)
    return response.text

if __name__ == '__main__':
    app.run(host='localhost', port=8083)