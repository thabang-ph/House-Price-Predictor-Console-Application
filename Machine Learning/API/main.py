from fastapi import FastAPI
import joblib
import pandas as pd

#create an instance of the FastAPI class
app= FastAPI()

#get model
house_predictor_model = joblib.load("../house_price_model_prediction.pkl")

#arrange input into dataframe
def restructure_input(house_size: float, num_bedrooms: int):
    input_data = {
        "size_m2": [house_size],
        "bedrooms": [num_bedrooms],
    }
    return pd.DataFrame(input_data)

#create endpoint for the root path
@app.get("/predictPrice")
def predict_house_price(house_size:float, num_bedrooms:int):
    #restructure input into dataframe
    input_df = restructure_input(house_size, num_bedrooms)
    #make prediction using the loaded model
    price = house_predictor_model.predict(input_df)[0]
    return {"predicted_price": price}