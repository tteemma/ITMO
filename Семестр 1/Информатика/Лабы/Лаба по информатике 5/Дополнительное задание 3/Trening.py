import plotly
import plotly.graph_objs as go
import plotly.express as px
from plotly.subplots import make_subplots

import numpy as np
import pandas as pd

x = np.arange(0, 5, 0.1)
def f(x):
    return x**2

fig = go.Figure()
fig.add_trace(go.Scatter(x = x, y = f(x), name="Hey"))
fig.add_trace(go.Scatter(x = x, y = x))
fig.show()