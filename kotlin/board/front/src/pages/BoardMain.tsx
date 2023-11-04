import React from "react";

function BoardMain() {

    const test = (e: any) => {
        console.log('Test Check !!');
        console.log(e);
        console.log('7777');
        console.log('after test !!!');
    }

    return (
        <div>
            <h1>Board Main !!</h1>
            <button onClick={test}>Click Button</button>
        </div>
    )
}

export default BoardMain;