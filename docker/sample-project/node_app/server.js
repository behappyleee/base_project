import express from 'express';

const app = express();

app.get('/', (req, res) => {
    res.send(
        `<h1>Hello From inside the very basic Node App ! </h1>`
    );
})

app.listen(3000);
