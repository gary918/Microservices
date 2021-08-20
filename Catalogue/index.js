const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.json())

app.listen(
    PORT,
    () => console.log(`Node App listening on port: ${PORT}`)
)

app.get('/listall', (req, res) => {
    res.status(200).send(
        [{
            id: 108,
            name: 'Tesla'
        },
        {
            id: 109,
            name: 'BMW'
        }]
        )
});

app.get('/product', (req, res) => {
    res.status(200).send(
        {
            id: 108,
            name: 'Tesla'
        })
});

app.get('/all', (req, res) => {
    res.status(200).send('all')
});
