from fastapi import FastAPI, HTTPException
import joblib
import pandas as pd

# Create an instance of the FastAPI class
app = FastAPI()

# Get model
house_predictor_model = joblib.load("../house_price_model_prediction.pkl")

# Arrange input into dataframe
def restructure_input(house_size: float, num_bedrooms: int):

    input_data = {
        "size_m2": [house_size],
        "bedrooms": [num_bedrooms],
    }

    return pd.DataFrame(input_data)


# Create endpoint for prediction
@app.get("/predictPrice")
def predict_house_price(house_size: float, num_bedrooms: int):

    # Validate input
    if house_size <= 0:
        raise HTTPException(
            status_code=400,
            detail="House size must be greater than zero."
        )

    if num_bedrooms <= 0:
        raise HTTPException(
            status_code=400,
            detail="Number of bedrooms must be greater than zero."
        )

    try:

        # Restructure input into dataframe
        input_df = restructure_input(house_size, num_bedrooms)

        # Make prediction using the loaded model
        price = house_predictor_model.predict(input_df)[0]

        # Return prediction
        return {"predicted_price": float(price)}

    except HTTPException:
        raise

    except Exception:
        raise HTTPException(
            status_code=500,
            detail="An error occurred while predicting the house price."
        )