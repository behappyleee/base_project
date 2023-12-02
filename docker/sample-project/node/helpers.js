const connectToDataBase = () => {
    const dummyPromise = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve()
    
        // 1초의 타이머가 작동
        }, 1000)

    });
    return dummyPromise;
}

export default connectToDataBase;