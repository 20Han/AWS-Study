exports.handler = async (event, context, callback) => {
    //get인지 post 인지
    const operation = event.httpMethod;
    
    switch(operation) {
        case 'GET':
            let data = {
                'id' : 1,
                'name' : 'oliver'
            }
            callback(null, {
                'statusCode' : 200,
                'headers' : {'Access-Control-Allow-Origin' : '*'},
                'body' : JSON.stringify(data)
            });
            break;
        case 'POST':
            callback(null, {
                'statusCode' : 200
            });
            break;
        default:
            callback(new Error('Operation Error : "${operation}"'))
    }
};
